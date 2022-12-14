// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.qs;

import android.content.Context;
import android.util.AttributeSet;
import com.android.systemui.plugins.ActivityStarter;
import com.android.systemui.statusbar.phone.StatusBarIconController;
import com.android.systemui.statusbar.policy.NextAlarmController;
import com.android.systemui.statusbar.policy.ZenModeController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class QuickStatusBarHeader_Factory implements Factory<QuickStatusBarHeader> {
  private final Provider<Context> contextProvider;

  private final Provider<AttributeSet> attrsProvider;

  private final Provider<NextAlarmController> nextAlarmControllerProvider;

  private final Provider<ZenModeController> zenModeControllerProvider;

  private final Provider<StatusBarIconController> statusBarIconControllerProvider;

  private final Provider<ActivityStarter> activityStarterProvider;

  public QuickStatusBarHeader_Factory(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<NextAlarmController> nextAlarmControllerProvider,
      Provider<ZenModeController> zenModeControllerProvider,
      Provider<StatusBarIconController> statusBarIconControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    this.contextProvider = contextProvider;
    this.attrsProvider = attrsProvider;
    this.nextAlarmControllerProvider = nextAlarmControllerProvider;
    this.zenModeControllerProvider = zenModeControllerProvider;
    this.statusBarIconControllerProvider = statusBarIconControllerProvider;
    this.activityStarterProvider = activityStarterProvider;
  }

  @Override
  public QuickStatusBarHeader get() {
    return provideInstance(
        contextProvider,
        attrsProvider,
        nextAlarmControllerProvider,
        zenModeControllerProvider,
        statusBarIconControllerProvider,
        activityStarterProvider);
  }

  public static QuickStatusBarHeader provideInstance(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<NextAlarmController> nextAlarmControllerProvider,
      Provider<ZenModeController> zenModeControllerProvider,
      Provider<StatusBarIconController> statusBarIconControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    return new QuickStatusBarHeader(
        contextProvider.get(),
        attrsProvider.get(),
        nextAlarmControllerProvider.get(),
        zenModeControllerProvider.get(),
        statusBarIconControllerProvider.get(),
        activityStarterProvider.get());
  }

  public static QuickStatusBarHeader_Factory create(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<NextAlarmController> nextAlarmControllerProvider,
      Provider<ZenModeController> zenModeControllerProvider,
      Provider<StatusBarIconController> statusBarIconControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    return new QuickStatusBarHeader_Factory(
        contextProvider,
        attrsProvider,
        nextAlarmControllerProvider,
        zenModeControllerProvider,
        statusBarIconControllerProvider,
        activityStarterProvider);
  }

  public static QuickStatusBarHeader newQuickStatusBarHeader(
      Context context,
      AttributeSet attrs,
      NextAlarmController nextAlarmController,
      ZenModeController zenModeController,
      StatusBarIconController statusBarIconController,
      ActivityStarter activityStarter) {
    return new QuickStatusBarHeader(
        context,
        attrs,
        nextAlarmController,
        zenModeController,
        statusBarIconController,
        activityStarter);
  }
}
