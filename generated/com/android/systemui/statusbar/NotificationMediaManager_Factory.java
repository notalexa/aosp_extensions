// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar;

import android.content.Context;
import com.android.systemui.statusbar.notification.NotificationEntryManager;
import com.android.systemui.statusbar.phone.ShadeController;
import com.android.systemui.statusbar.phone.StatusBarWindowController;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NotificationMediaManager_Factory implements Factory<NotificationMediaManager> {
  private final Provider<Context> contextProvider;

  private final Provider<ShadeController> shadeControllerProvider;

  private final Provider<StatusBarWindowController> statusBarWindowControllerProvider;

  private final Provider<NotificationEntryManager> notificationEntryManagerProvider;

  private final Provider<MediaArtworkProcessor> mediaArtworkProcessorProvider;

  public NotificationMediaManager_Factory(
      Provider<Context> contextProvider,
      Provider<ShadeController> shadeControllerProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider,
      Provider<MediaArtworkProcessor> mediaArtworkProcessorProvider) {
    this.contextProvider = contextProvider;
    this.shadeControllerProvider = shadeControllerProvider;
    this.statusBarWindowControllerProvider = statusBarWindowControllerProvider;
    this.notificationEntryManagerProvider = notificationEntryManagerProvider;
    this.mediaArtworkProcessorProvider = mediaArtworkProcessorProvider;
  }

  @Override
  public NotificationMediaManager get() {
    return provideInstance(
        contextProvider,
        shadeControllerProvider,
        statusBarWindowControllerProvider,
        notificationEntryManagerProvider,
        mediaArtworkProcessorProvider);
  }

  public static NotificationMediaManager provideInstance(
      Provider<Context> contextProvider,
      Provider<ShadeController> shadeControllerProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider,
      Provider<MediaArtworkProcessor> mediaArtworkProcessorProvider) {
    return new NotificationMediaManager(
        contextProvider.get(),
        DoubleCheck.lazy(shadeControllerProvider),
        DoubleCheck.lazy(statusBarWindowControllerProvider),
        notificationEntryManagerProvider.get(),
        mediaArtworkProcessorProvider.get());
  }

  public static NotificationMediaManager_Factory create(
      Provider<Context> contextProvider,
      Provider<ShadeController> shadeControllerProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<NotificationEntryManager> notificationEntryManagerProvider,
      Provider<MediaArtworkProcessor> mediaArtworkProcessorProvider) {
    return new NotificationMediaManager_Factory(
        contextProvider,
        shadeControllerProvider,
        statusBarWindowControllerProvider,
        notificationEntryManagerProvider,
        mediaArtworkProcessorProvider);
  }

  public static NotificationMediaManager newNotificationMediaManager(
      Context context,
      Lazy<ShadeController> shadeController,
      Lazy<StatusBarWindowController> statusBarWindowController,
      NotificationEntryManager notificationEntryManager,
      MediaArtworkProcessor mediaArtworkProcessor) {
    return new NotificationMediaManager(
        context,
        shadeController,
        statusBarWindowController,
        notificationEntryManager,
        mediaArtworkProcessor);
  }
}