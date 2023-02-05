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

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

public class ChallengeView extends FrameLayout {
    ServiceConnection currentConnection;
    boolean showing;
    IBinder challengeService;
    ChallengeCallback callback;
    ChallengeConnection conn;
    IBinder token;
    Context context;
    ResultListener listener;
    Intent intent;

    private String TAG=getClass().getSimpleName();

    public ChallengeView(Context context) {
        super(context);
        init();
    }

    public ChallengeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public ChallengeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ChallengeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    protected void init() {
        callback=new ChallengeCallback.Stub() {
            @Override
            public void challengeSolved(boolean success,Intent intent) throws RemoteException {
                if(listener!=null) {
                    listener.challengeSolved(success,intent);
                } else {
                    Log.i(TAG, "challengeSolved in callback");
                }
            }
            @Override
            public void onError() throws RemoteException {
                Log.i(TAG,"onError in callback!");
            }
            @Override
            public void cancelled() throws RemoteException {
                fireChallengeCancelled();
            }

            @Override
            public void doze(long delay) throws RemoteException {
            	fireDoze(delay);
            }

        };
    }

    protected void hide(int animationTime) {
        if(conn!=null) try {
            conn.hide(token,animationTime);
        } catch(Throwable t) {
        } finally {
            showing=false;
        }
    }

    protected void fireChallengeCancelled() {
    }

    protected void fireDoze(long delay) {
    }

    private void showService() {
        try {
            int[] loc=new int[2];
            getLocationInWindow(loc);
            showing=true;
            conn.show(token,callback,loc[0],loc[1],getWidth(),getHeight());
        } catch (RemoteException e) {
            Log.e(TAG,"Call failed!",e);
        }
    }

    public synchronized void show(Intent serviceIntent) {
        if((conn==null||intent==null||!serviceIntent.equals(this.intent))) {
            stopService();
            startService(serviceIntent,this::showService);
        } else {
            showService();
        }
    }

    protected void onChallengeDied() {
    }

    private void startService(Intent serviceIntent, Runnable o) {
        context.bindService(serviceIntent, currentConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                if(currentConnection==this) {
                    intent=serviceIntent;
                    challengeService=service;
                    try {
                        service.linkToDeath(new IBinder.DeathRecipient() {
                            @Override
                            public void binderDied() {
                                service.unlinkToDeath(this,0);
                                conn=null;
                                if(showing) {
                                    showing=false;
                                    onChallengeDied();
                                }
                            }
                        },0);
                    } catch(Throwable t) {}
                    conn = ChallengeConnection.Stub.asInterface(service);
                    o.run();
                }
            }

            @Override
			public void onBindingDied(ComponentName name) {
            	System.out.println("conetxt onBindingdied");
				ServiceConnection.super.onBindingDied(name);
				onChallengeDied();
			}

			@Override
			public void onNullBinding(ComponentName name) {
            	System.out.println("conetxt onNullBinding");
				ServiceConnection.super.onNullBinding(name);
				onChallengeDied();
			}

			@Override
            public void onServiceDisconnected(ComponentName name) {
                Log.w(TAG,"Service disconnected");
                if(currentConnection==this) {
                    if(showing) {
                        Log.w(TAG,"View is marked as showing.");
                    }
                    showing=false;
                    conn = null;
                    currentConnection = null;
                }
            }
        }, Context.BIND_AUTO_CREATE);
    }

    protected boolean stopService() {
        if(conn!=null) {
            showing=false;
            try {
                conn.detach(token);
            } catch (RemoteException e) {
            }
            conn = null;
            Log.i(TAG, "Unbind ChallengeConnection, activity token=" + token);
            context.unbindService(currentConnection);
            return true;
        } else {
            return false;
        }
    }

    public void onStop() {
        listener=null;
        stopService();
    }

    public void onStart(Context context,IBinder token,ResultListener listener) {
        onStart(context,token);
        addResultListener(listener);
    }
    
    public void onStart(Context context,IBinder token) {
        this.context=context;
        this.token=token;
    }

    public void addResultListener(ResultListener listener) {
        this.listener = listener;
    }


    public interface ResultListener {
        void challengeSolved(boolean success,Intent intent);
        void doze(long delay);
    }
}
