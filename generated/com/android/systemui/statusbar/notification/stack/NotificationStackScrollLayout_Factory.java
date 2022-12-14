// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.notification.stack;

import android.content.Context;
import android.util.AttributeSet;
import com.android.systemui.plugins.ActivityStarter;
import com.android.systemui.plugins.statusbar.StatusBarStateController;
import com.android.systemui.statusbar.AmbientPulseManager;
import com.android.systemui.statusbar.notification.DynamicPrivacyController;
import com.android.systemui.statusbar.policy.ConfigurationController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NotificationStackScrollLayout_Factory
    implements Factory<NotificationStackScrollLayout> {
  private final Provider<Context> contextProvider;

  private final Provider<AttributeSet> attrsProvider;

  private final Provider<Boolean> allowLongPressProvider;

  private final Provider<NotificationRoundnessManager> notificationRoundnessManagerProvider;

  private final Provider<AmbientPulseManager> ambientPulseManagerProvider;

  private final Provider<DynamicPrivacyController> dynamicPrivacyControllerProvider;

  private final Provider<ConfigurationController> configurationControllerProvider;

  private final Provider<ActivityStarter> activityStarterProvider;

  private final Provider<StatusBarStateController> statusBarStateControllerProvider;

  public NotificationStackScrollLayout_Factory(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<Boolean> allowLongPressProvider,
      Provider<NotificationRoundnessManager> notificationRoundnessManagerProvider,
      Provider<AmbientPulseManager> ambientPulseManagerProvider,
      Provider<DynamicPrivacyController> dynamicPrivacyControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<ActivityStarter> activityStarterProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider) {
    this.contextProvider = contextProvider;
    this.attrsProvider = attrsProvider;
    this.allowLongPressProvider = allowLongPressProvider;
    this.notificationRoundnessManagerProvider = notificationRoundnessManagerProvider;
    this.ambientPulseManagerProvider = ambientPulseManagerProvider;
    this.dynamicPrivacyControllerProvider = dynamicPrivacyControllerProvider;
    this.configurationControllerProvider = configurationControllerProvider;
    this.activityStarterProvider = activityStarterProvider;
    this.statusBarStateControllerProvider = statusBarStateControllerProvider;
  }

  @Override
  public NotificationStackScrollLayout get() {
    return provideInstance(
        contextProvider,
        attrsProvider,
        allowLongPressProvider,
        notificationRoundnessManagerProvider,
        ambientPulseManagerProvider,
        dynamicPrivacyControllerProvider,
        configurationControllerProvider,
        activityStarterProvider,
        statusBarStateControllerProvider);
  }

  public static NotificationStackScrollLayout provideInstance(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<Boolean> allowLongPressProvider,
      Provider<NotificationRoundnessManager> notificationRoundnessManagerProvider,
      Provider<AmbientPulseManager> ambientPulseManagerProvider,
      Provider<DynamicPrivacyController> dynamicPrivacyControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<ActivityStarter> activityStarterProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider) {
    return new NotificationStackScrollLayout(
        contextProvider.get(),
        attrsProvider.get(),
        allowLongPressProvider.get(),
        notificationRoundnessManagerProvider.get(),
        ambientPulseManagerProvider.get(),
        dynamicPrivacyControllerProvider.get(),
        configurationControllerProvider.get(),
        activityStarterProvider.get(),
        statusBarStateControllerProvider.get());
  }

  public static NotificationStackScrollLayout_Factory create(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<Boolean> allowLongPressProvider,
      Provider<NotificationRoundnessManager> notificationRoundnessManagerProvider,
      Provider<AmbientPulseManager> ambientPulseManagerProvider,
      Provider<DynamicPrivacyController> dynamicPrivacyControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<ActivityStarter> activityStarterProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider) {
    return new NotificationStackScrollLayout_Factory(
        contextProvider,
        attrsProvider,
        allowLongPressProvider,
        notificationRoundnessManagerProvider,
        ambientPulseManagerProvider,
        dynamicPrivacyControllerProvider,
        configurationControllerProvider,
        activityStarterProvider,
        statusBarStateControllerProvider);
  }

  public static NotificationStackScrollLayout newNotificationStackScrollLayout(
      Context context,
      AttributeSet attrs,
      boolean allowLongPress,
      Object notificationRoundnessManager,
      AmbientPulseManager ambientPulseManager,
      DynamicPrivacyController dynamicPrivacyController,
      ConfigurationController configurationController,
      ActivityStarter activityStarter,
      StatusBarStateController statusBarStateController) {
    return new NotificationStackScrollLayout(
        context,
        attrs,
        allowLongPress,
        (NotificationRoundnessManager) notificationRoundnessManager,
        ambientPulseManager,
        dynamicPrivacyController,
        configurationController,
        activityStarter,
        statusBarStateController);
  }
}
