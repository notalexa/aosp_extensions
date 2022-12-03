/*
 * Copyright (C) 2022 Not Alexa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.service.trust;

import static android.view.WindowManager.LayoutParams.TYPE_KEYGUARD_CHALLENGE;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.HashMap;
import java.util.Map;

import android.service.trust.ChallengeCallback;
import android.service.trust.ChallengeConnection;

public class ChallengeService extends Service {
    private static final String TAG= ChallengeService.class.getSimpleName();
    private static final int MSG_SHOW=0;
    private static final int MSG_HIDE=1;
    private static final int MSG_DETACH=2;
    private static final String DATA_TOKEN="token";
    private static final String DATA_W="w";
    private static final String DATA_H="h";
    private static final String DATA_TIMEOUT="t";
    private static final String DATA_PRIVILEGED="privileged";
    private IBinder conn;
    private Interpolator mLinearOutSlowInInterpolator;
    private Interpolator mFastOutLinearInInterpolator;
    private Map<IBinder,ChallengeDialog> dialogs=new HashMap<>();

    private static Handler mHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ChallengeDialog dialog;
            switch(msg.what) {
                case MSG_SHOW:
                    dialog=((Attacher)msg.obj).attach(msg.arg1,msg.arg2,msg.getData().getInt(DATA_W),msg.getData().getInt(DATA_H));
                    if(!dialog.isShowing()) {
                        dialog.show();
                    } else {
                        Log.w(TAG,"Dialog already showing.");
                        dialog.update();
                    }

                    break;
                case MSG_HIDE:
                    dialog=(ChallengeDialog)msg.obj;
                    if(dialog.isShowing()) {
                        dialog.hide(msg.getData().getInt(DATA_TIMEOUT));
                    }
                    break;
                case MSG_DETACH:
                    dialog=(ChallengeDialog)msg.obj;
                    if(dialog.isShowing()) {
                        dialog.hide();
                    }
                    dialog.cancel();
                    break;
            }
        }
    };

	public boolean privileged() {
        return checkCallingPermission("android.permission.STATUS_BAR")==android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    public ChallengeService() {
        conn=new ChallengeConnection.Stub() {
            @Override
            public void hide(IBinder token,int timeout) throws RemoteException {
                Log.i(ChallengeConnection.class.getSimpleName(),"Hide token "+token);
                ChallengeDialog dialog=dialogs.get(token);
                if(dialog!=null) {
                    Message msg = mHandler.obtainMessage(MSG_HIDE, dialog);
                msg.getData().putInt(DATA_TIMEOUT,timeout);
                    msg.sendToTarget();
                }
            }

            @Override
            public void detach(IBinder token) throws RemoteException {
                Log.i(ChallengeConnection.class.getSimpleName(),"Detach token "+token);
                ChallengeService.ChallengeDialog dialog=dialogs.get(token);
                if(dialog!=null) {
                    Message msg = mHandler.obtainMessage(MSG_DETACH, dialog);
                    msg.sendToTarget();
                }
            }

            public void show(IBinder token, ChallengeCallback callback, int x, int y, int w, int h) throws RemoteException {
                Log.i(ChallengeConnection.class.getSimpleName(),"Show dialog with token "+token+", privileged="+privileged());
                Message msg=mHandler.obtainMessage(MSG_SHOW,x,y,new Attacher(token,callback,privileged()));
                msg.getData().putInt(DATA_W,w);
                msg.getData().putInt(DATA_H,h);
                msg.getData().putBoolean(DATA_PRIVILEGED,privileged());
                msg.sendToTarget();
            }

            @Override
            public boolean needsInput() throws RemoteException {
                return ChallengeService.this.needsInput();
            }

            @Override
            public int challengeCount() throws RemoteException {
                return ChallengeService.this.challengeCount();
            }


        };
    }

    public ChallengeDialog getDialog(IBinder key,boolean privileged) {
        ChallengeDialog dialog=dialogs.get(key);
        if(dialog==null) {
            dialog=new ChallengeDialog(key,privileged);
            dialogs.put(key,dialog);
        } else {
            Log.i(TAG,"Dialog unknown for token "+key);
        }
        return dialog;
    }

    public boolean needsInput() {
        return false;
    }

    public int challengeCount() {
        return 1;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return conn;
    }

    protected LayoutInflater mInflater;
    protected int viewId;
    protected int buttonSolved;

    @Override
    public void onCreate() {
        super.onCreate();
        mInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(
                this, android.R.interpolator.linear_out_slow_in);
        mFastOutLinearInInterpolator = AnimationUtils.loadInterpolator(
                this, android.R.interpolator.fast_out_linear_in);
    }

    protected void setChallengeView(int view,int solveButton) {
        this.viewId=view;
        this.buttonSolved =solveButton;
    }

    protected void onChallengeShow(View challenge,View.OnClickListener solvedListener) {
       onChallengeShow(challenge);
    }
    
    protected void onChallengeShow(View challenge) {
    }

    protected void onChallengeHide(View challenge) {
    }

    protected void onShuffle(View challenge) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public class ChallengeDialog {
        IBinder token;
        Dialog dialog;
        View challengeView;
        ChallengeCallback callback;
        public ChallengeDialog(IBinder token,boolean privileged) {
            this.token=token;
            Log.i("ChallengeConnection","Create dialog with token "+token);
            dialog=new Dialog(ChallengeService.this) {
                @Override
                public void onBackPressed() {
                    if(callback!=null) try {
                        callback.cancelled();
                    } catch(Throwable t) {
                    }
                }
                @Override
                public void show() {
                    challengeView.setAlpha(0);
                    challengeView.setTranslationY(getWindow().getAttributes().y);
                    super.show();
                    challengeView.animate().alpha(1).translationY(0).withLayer().setDuration(300).setInterpolator(mLinearOutSlowInInterpolator);
                }
            };
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams attributes=dialog.getWindow().getAttributes();
            attributes.token=token;
            if(privileged) {
                attributes.type=TYPE_KEYGUARD_CHALLENGE;
            }
            attributes.gravity=Gravity.TOP|Gravity.LEFT;
            dialog.getWindow().setAttributes(attributes);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN|WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_DIM_BEHIND|WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN|WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            challengeView=mInflater.inflate(viewId,null);
            int r= buttonSolved;
            if(r>=0) {
                challengeView.findViewById(r).setOnClickListener(getChallengedSolvedListener());
            }
            dialog.setContentView(challengeView);
        }

        public void init(ChallengeCallback callback,int x,int y,int w,int h) {
            this.callback=callback;
            WindowManager.LayoutParams attributes=dialog.getWindow().getAttributes();
            attributes.x=x;
            attributes.y=y;
            attributes.width=w;
            attributes.height=h;
            dialog.getWindow().setAttributes(attributes);
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        }

        public void show() {
            onChallengeShow(challengeView,getChallengedSolvedListener());
            dialog.show();
        }
        
        public void hide(int timeout) {
            if(timeout>0) {
                challengeView.animate().alpha(0f).translationY(0).setInterpolator(mFastOutLinearInInterpolator).setDuration(timeout).withEndAction(ChallengeDialog.this::hide);
            } else {
                hide();
            }
        }

        public void hide() {
            onChallengeHide(challengeView);
            dialog.hide();
        }

        public boolean isShowing() {
            return dialog.isShowing();
        }

        public void cancel() {
            dialogs.remove(token);
            dialog.dismiss();
        }

        public void challengeSolved() {
            if(dialog.isShowing()) {
                try {
                    callback.challengeSolved(true);
                } catch(RemoteException e) {}
            }
        }

        public View.OnClickListener getChallengedSolvedListener() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    challengeSolved();
                }
            };
        }

        public void update() {
            onChallengeShow(challengeView,getChallengedSolvedListener());
        }
    }

    public class Attacher {
        IBinder token;
        ChallengeCallback callback;
        boolean privileged;

        public Attacher(IBinder token,ChallengeCallback callback,boolean privileged) {
            this.token=token;
            this.callback=callback;
            this.privileged=privileged;
        }

        public ChallengeService.ChallengeDialog attach() {
            return getDialog(token,privileged);
        }
        public ChallengeService.ChallengeDialog attach(int x,int y,int w,int h) {
            ChallengeService.ChallengeDialog dialog=getDialog(token,privileged);
            dialog.init(callback,x,y,w,h);
            return dialog;
        }
    }
}
