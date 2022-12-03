// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.bubbles;

import android.content.Context;
import com.android.systemui.statusbar.notification.NotificationInterruptionStateProvider;
import com.android.systemui.statusbar.phone.StatusBarWindowController;
import com.android.systemui.statusbar.policy.ConfigurationController;
import com.android.systemui.statusbar.policy.ZenModeController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BubbleController_Factory implements Factory<BubbleController> {
  private final Provider<Context> contextProvider;

  private final Provider<StatusBarWindowController> statusBarWindowControllerProvider;

  private final Provider<BubbleData> dataProvider;

  private final Provider<ConfigurationController> configurationControllerProvider;

  private final Provider<NotificationInterruptionStateProvider> interruptionStateProvider;

  private final Provider<ZenModeController> zenModeControllerProvider;

  public BubbleController_Factory(
      Provider<Context> contextProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<BubbleData> dataProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<NotificationInterruptionStateProvider> interruptionStateProvider,
      Provider<ZenModeController> zenModeControllerProvider) {
    this.contextProvider = contextProvider;
    this.statusBarWindowControllerProvider = statusBarWindowControllerProvider;
    this.dataProvider = dataProvider;
    this.configurationControllerProvider = configurationControllerProvider;
    this.interruptionStateProvider = interruptionStateProvider;
    this.zenModeControllerProvider = zenModeControllerProvider;
  }

  @Override
  public BubbleController get() {
    return provideInstance(
        contextProvider,
        statusBarWindowControllerProvider,
        dataProvider,
        configurationControllerProvider,
        interruptionStateProvider,
        zenModeControllerProvider);
  }

  public static BubbleController provideInstance(
      Provider<Context> contextProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<BubbleData> dataProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<NotificationInterruptionStateProvider> interruptionStateProvider,
      Provider<ZenModeController> zenModeControllerProvider) {
    return new BubbleController(
        contextProvider.get(),
        statusBarWindowControllerProvider.get(),
        dataProvider.get(),
        configurationControllerProvider.get(),
        interruptionStateProvider.get(),
        zenModeControllerProvider.get());
  }

  public static BubbleController_Factory create(
      Provider<Context> contextProvider,
      Provider<StatusBarWindowController> statusBarWindowControllerProvider,
      Provider<BubbleData> dataProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<NotificationInterruptionStateProvider> interruptionStateProvider,
      Provider<ZenModeController> zenModeControllerProvider) {
    return new BubbleController_Factory(
        contextProvider,
        statusBarWindowControllerProvider,
        dataProvider,
        configurationControllerProvider,
        interruptionStateProvider,
        zenModeControllerProvider);
  }

  public static BubbleController newBubbleController(
      Context context,
      StatusBarWindowController statusBarWindowController,
      BubbleData data,
      ConfigurationController configurationController,
      NotificationInterruptionStateProvider interruptionStateProvider,
      ZenModeController zenModeController) {
    return new BubbleController(
        context,
        statusBarWindowController,
        data,
        configurationController,
        interruptionStateProvider,
        zenModeController);
  }
}
