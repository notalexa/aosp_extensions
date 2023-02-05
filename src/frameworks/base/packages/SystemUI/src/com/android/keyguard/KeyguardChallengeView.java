package com.android.keyguard;

import com.android.internal.widget.LockPatternUtils;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.service.trust.AuthType;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class KeyguardChallengeView extends android.service.trust.ChallengeView implements KeyguardSecurityView, EmergencyButton.EmergencyButtonCallback {
	private static final String TAG="KeyguardChallengeView";
	// State handling
	boolean mDismissing;
	
	private final int mDisappearYTranslation;
	private final Interpolator mLinearOutSlowInInterpolator;
    private final Interpolator mFastOutLinearInInterpolator;
	
    private LockPatternUtils mLockPatternUtils;
    private KeyguardSecurityCallback mCallback;
    private View mBlueScreen;
    private View mNoChallenge;
    private KeyguardMessageArea mSecurityMessageDisplay;
    private PowerManager.WakeLock showLock;
    private Handler mHandler;
    private long mShowtime;

	public KeyguardChallengeView(Context context) {
		this(context,null);
	}

	public KeyguardChallengeView(Context context, AttributeSet attrs) {
		super(context, attrs);
        mDisappearYTranslation = getResources().getDimensionPixelSize(
                R.dimen.disappear_y_translation);
        mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(
                context, android.R.interpolator.linear_out_slow_in);
        mFastOutLinearInInterpolator = AnimationUtils.loadInterpolator(
                context, android.R.interpolator.fast_out_linear_in);
        mHandler=new Handler();
	}
	
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PowerManager powerManager = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
        showLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "show challenge");
        showLock.setReferenceCounted(false);
        mSecurityMessageDisplay = KeyguardMessageArea.findSecurityMessageDisplay(this);
        onStart(mContext, getApplicationWindowToken(), new android.service.trust.ChallengeView.ResultListener() {
            @Override
            public void challengeSolved(boolean success,Intent intent) {
                showLock.release();
                mHandler.post(()->{
                    if(success) {
                        unlock();
                    } else {
                        onResume(VIEW_REVEALED);
                    }
                });
            }

			@Override
			public void doze(long delay) {
			}
        });
    }

    @Override
    protected void fireChallengeCancelled() {
        showLock.release();
        mCallback.reset();
        mCallback.onCancelClicked();
    }

    @Override
    protected void fireDoze(long delay) {
        delay=Math.max(delay, Math.max(10000+mShowtime-SystemClock.uptimeMillis(),500));
    	if(showLock.isHeld()) {
    		showLock.acquire(delay);
    	}
        mHandler.postDelayed(()->{
        	showLock.release();
            PowerManager powerManager = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
            powerManager.goToSleep(SystemClock.uptimeMillis());
        },delay);
    }

    @Override
    protected void onChallengeDied() {
        showLock.release();
        if(mBlueScreen!=null) {
            mHandler.post(() -> 
                mBlueScreen.setVisibility(View.VISIBLE));
        }
    }

    private void unlock() {
    	if(!mDismissing) {
	    	int userId=KeyguardUpdateMonitor.getCurrentUser();
	    	boolean dismissKeyguard = KeyguardUpdateMonitor.getCurrentUser() == userId;
	        mCallback.reportUnlockAttempt(userId, AuthType.Challenge,true, 0);
	        if (dismissKeyguard) {
	            mDismissing = true;
	            mCallback.dismiss(AuthType.Challenge,true, userId);
	        }
    	}
    }
    
	@Override
	public void setKeyguardCallback(KeyguardSecurityCallback callback) {
		mCallback=callback;
	}

	@Override
	public void setLockPatternUtils(LockPatternUtils utils) {
		mLockPatternUtils=utils;
	}

	@Override
	public void reset() {
		mDismissing=false;
	}
	
    @Override
    protected void onFinishInflate() {
    	mLockPatternUtils = mLockPatternUtils == null
                ? new LockPatternUtils(mContext) : mLockPatternUtils;
        EmergencyButton button = findViewById(R.id.emergency_call_button);
        if (button != null) {
        	button.setCallback(this);
        }
        mBlueScreen=findViewById(R.id.challenge_bluescreen);
        if(mBlueScreen!=null) {
            mBlueScreen.setVisibility(View.GONE);
            mBlueScreen.setOnClickListener(view -> {
        		unlock();
        	});
        }
        mNoChallenge=findViewById(R.id.challenge_nochallenge);
        if(mNoChallenge!=null) {
            mNoChallenge.setVisibility(View.GONE);
            mNoChallenge.setOnClickListener(view -> {
        		unlock();
        	});
        }
    }
    
    private void clearSecurityMessage() {
        if (mSecurityMessageDisplay != null) {
            mSecurityMessageDisplay.setMessage("");
        }
    }


	@Override
	public void onPause() {
        showLock.release();
        if(mBlueScreen!=null) {
            mBlueScreen.setVisibility(View.GONE);
        }
        if(mNoChallenge!=null) {
            mNoChallenge.setVisibility(View.GONE);
        }
		clearSecurityMessage();
        stopService();
	}

    protected Intent nextIntent() {
        return mLockPatternUtils.nextChallenge(KeyguardUpdateMonitor.getCurrentUser());
    }

	@Override
	public void onResume(int reason) {
        if(showLock!=null&&!showLock.isHeld()) {
        	mShowtime=SystemClock.uptimeMillis();
            Intent nextIntent=nextIntent();
            if(nextIntent!=null) {
                show(nextIntent);
                showLock.acquire(60000);
            } else if(mNoChallenge!=null) {
               mNoChallenge.setVisibility(View.VISIBLE);
            }
        }
	}

	@Override
	public boolean needsInput() {
		return true;
	}

	@Override
	public KeyguardSecurityCallback getCallback() {
		return mCallback;
	}

	@Override
	public void showPromptReason(int reason) {
	    // Weak security view has no prompt
	}

	@Override
	public void showMessage(CharSequence message, ColorStateList colorState) {
        mSecurityMessageDisplay.setNextMessageColor(colorState);
        mSecurityMessageDisplay.setMessage(message);
	}

	@Override
	public void showUsabilityHint() {
		// Nothing in KeyguardChallengeView
	}

	@Override
	public void startAppearAnimation() {
	}

	@Override
	public boolean startDisappearAnimation(Runnable finishRunnable) {
        int animationTime=100;
        hide(animationTime);
        animate()
        	.alpha(0f)
        	.translationY(mDisappearYTranslation)
        	.setInterpolator(mFastOutLinearInInterpolator)
        	.setDuration(animationTime)
        	.withEndAction(finishRunnable);
        return true;
	}

	@Override
	public CharSequence getTitle() {
		return "Challenge unlock.";
	}

	@Override
	public void onEmergencyButtonClickedWhenInCall() {
		mCallback.reset();
	}
}
