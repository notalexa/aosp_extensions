// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.notification.logging;

import com.android.systemui.UiOffloadThread;
import com.android.systemui.plugins.statusbar.StatusBarStateController;
import com.android.systemui.statusbar.NotificationListener;
import com.android.systemui.statusbar.notification.NotificationEntryManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NotificationLogger_Factory implements Factory<NotificationLogger> {
  private final Provider<NotificationListener> notificationListenerProvider;

  private final Provider<UiOffloadThread> uiOffloadThreadProvider;

  private final Provider<NotificationEntryManager> entryManagerProvider;

  private final Provider<StatusBarStateController> statusBarStateControllerProvider;

  private final Provider<NotificationLogger.ExpansionStateLogger> expansionStateLoggerProvider;

  public NotificationLogger_Factory(
      Provider<NotificationListener> notificationListenerProvider,
      Provider<UiOffloadThread> uiOffloadThreadProvider,
      Provider<NotificationEntryManager> entryManagerProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<NotificationLogger.ExpansionStateLogger> expansionStateLoggerProvider) {
    this.notificationListenerProvider = notificationListenerProvider;
    this.uiOffloadThreadProvider = uiOffloadThreadProvider;
    this.entryManagerProvider = entryManagerProvider;
    this.statusBarStateControllerProvider = statusBarStateControllerProvider;
    this.expansionStateLoggerProvider = expansionStateLoggerProvider;
  }

  @Override
  public NotificationLogger get() {
    return provideInstance(
        notificationListenerProvider,
        uiOffloadThreadProvider,
        entryManagerProvider,
        statusBarStateControllerProvider,
        expansionStateLoggerProvider);
  }

  public static NotificationLogger provideInstance(
      Provider<NotificationListener> notificationListenerProvider,
      Provider<UiOffloadThread> uiOffloadThreadProvider,
      Provider<NotificationEntryManager> entryManagerProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<NotificationLogger.ExpansionStateLogger> expansionStateLoggerProvider) {
    return new NotificationLogger(
        notificationListenerProvider.get(),
        uiOffloadThreadProvider.get(),
        entryManagerProvider.get(),
        statusBarStateControllerProvider.get(),
        expansionStateLoggerProvider.get());
  }

  public static NotificationLogger_Factory create(
      Provider<NotificationListener> notificationListenerProvider,
      Provider<UiOffloadThread> uiOffloadThreadProvider,
      Provider<NotificationEntryManager> entryManagerProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<NotificationLogger.ExpansionStateLogger> expansionStateLoggerProvider) {
    return new NotificationLogger_Factory(
        notificationListenerProvider,
        uiOffloadThreadProvider,
        entryManagerProvider,
        statusBarStateControllerProvider,
        expansionStateLoggerProvider);
  }

  public static NotificationLogger newNotificationLogger(
      NotificationListener notificationListener,
      UiOffloadThread uiOffloadThread,
      NotificationEntryManager entryManager,
      StatusBarStateController statusBarStateController,
      NotificationLogger.ExpansionStateLogger expansionStateLogger) {
    return new NotificationLogger(
        notificationListener,
        uiOffloadThread,
        entryManager,
        statusBarStateController,
        expansionStateLogger);
  }
}