// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.policy;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NextAlarmControllerImpl_Factory implements Factory<NextAlarmControllerImpl> {
  private final Provider<Context> contextProvider;

  public NextAlarmControllerImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NextAlarmControllerImpl get() {
    return provideInstance(contextProvider);
  }

  public static NextAlarmControllerImpl provideInstance(Provider<Context> contextProvider) {
    return new NextAlarmControllerImpl(contextProvider.get());
  }

  public static NextAlarmControllerImpl_Factory create(Provider<Context> contextProvider) {
    return new NextAlarmControllerImpl_Factory(contextProvider);
  }

  public static NextAlarmControllerImpl newNextAlarmControllerImpl(Context context) {
    return new NextAlarmControllerImpl(context);
  }
}