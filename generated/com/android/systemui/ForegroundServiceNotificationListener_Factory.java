// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import android.content.Context;
import com.android.systemui.statusbar.notification.NotificationEntryManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ForegroundServiceNotificationListener_Factory
    implements Factory<ForegroundServiceNotificationListener> {
  private final Provider<Context> contextProvider;

  private final Provider<ForegroundServiceController> foregroundServiceControllerProvider;

  private final Provider<NotificationEntryManager> notificationEntryManagerProvider;

  public ForegroundServiceNotificationListener_Factory(
      Provider<Context> contextProvider,
      Provider<ForegroundServiceController> foregroundServiceControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider) {
    this.contextProvider = contextProvider;
    this.foregroundServiceControllerProvider = foregroundServiceControllerProvider;
    this.notificationEntryManagerProvider = notificationEntryManagerProvider;
  }

  @Override
  public ForegroundServiceNotificationListener get() {
    return provideInstance(
        contextProvider, foregroundServiceControllerProvider, notificationEntryManagerProvider);
  }

  public static ForegroundServiceNotificationListener provideInstance(
      Provider<Context> contextProvider,
      Provider<ForegroundServiceController> foregroundServiceControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider) {
    return new ForegroundServiceNotificationListener(
        contextProvider.get(),
        foregroundServiceControllerProvider.get(),
        notificationEntryManagerProvider.get());
  }

  public static ForegroundServiceNotificationListener_Factory create(
      Provider<Context> contextProvider,
      Provider<ForegroundServiceController> foregroundServiceControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider) {
    return new ForegroundServiceNotificationListener_Factory(
        contextProvider, foregroundServiceControllerProvider, notificationEntryManagerProvider);
  }

  public static ForegroundServiceNotificationListener newForegroundServiceNotificationListener(
      Context context,
      ForegroundServiceController foregroundServiceController,
      NotificationEntryManager notificationEntryManager) {
    return new ForegroundServiceNotificationListener(
        context, foregroundServiceController, notificationEntryManager);
  }
}
