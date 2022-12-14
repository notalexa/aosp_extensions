// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.phone;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.android.systemui.dock.DockManager;
import com.android.systemui.plugins.statusbar.StatusBarStateController;
import com.android.systemui.statusbar.policy.AccessibilityController;
import com.android.systemui.statusbar.policy.ConfigurationController;
import com.android.systemui.statusbar.policy.KeyguardMonitor;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LockIcon_Factory implements Factory<LockIcon> {
  private final Provider<Context> contextProvider;

  private final Provider<AttributeSet> attrsProvider;

  private final Provider<StatusBarStateController> statusBarStateControllerProvider;

  private final Provider<ConfigurationController> configurationControllerProvider;

  private final Provider<AccessibilityController> accessibilityControllerProvider;

  private final Provider<KeyguardMonitor> keyguardMonitorProvider;

  private final Provider<DockManager> dockManagerProvider;

  private final Provider<Handler> mainHandlerProvider;

  public LockIcon_Factory(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<AccessibilityController> accessibilityControllerProvider,
      Provider<KeyguardMonitor> keyguardMonitorProvider,
      Provider<DockManager> dockManagerProvider,
      Provider<Handler> mainHandlerProvider) {
    this.contextProvider = contextProvider;
    this.attrsProvider = attrsProvider;
    this.statusBarStateControllerProvider = statusBarStateControllerProvider;
    this.configurationControllerProvider = configurationControllerProvider;
    this.accessibilityControllerProvider = accessibilityControllerProvider;
    this.keyguardMonitorProvider = keyguardMonitorProvider;
    this.dockManagerProvider = dockManagerProvider;
    this.mainHandlerProvider = mainHandlerProvider;
  }

  @Override
  public LockIcon get() {
    return provideInstance(
        contextProvider,
        attrsProvider,
        statusBarStateControllerProvider,
        configurationControllerProvider,
        accessibilityControllerProvider,
        keyguardMonitorProvider,
        dockManagerProvider,
        mainHandlerProvider);
  }

  public static LockIcon provideInstance(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<AccessibilityController> accessibilityControllerProvider,
      Provider<KeyguardMonitor> keyguardMonitorProvider,
      Provider<DockManager> dockManagerProvider,
      Provider<Handler> mainHandlerProvider) {
    return new LockIcon(
        contextProvider.get(),
        attrsProvider.get(),
        statusBarStateControllerProvider.get(),
        configurationControllerProvider.get(),
        accessibilityControllerProvider.get(),
        keyguardMonitorProvider.get(),
        dockManagerProvider.get(),
        mainHandlerProvider.get());
  }

  public static LockIcon_Factory create(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<StatusBarStateController> statusBarStateControllerProvider,
      Provider<ConfigurationController> configurationControllerProvider,
      Provider<AccessibilityController> accessibilityControllerProvider,
      Provider<KeyguardMonitor> keyguardMonitorProvider,
      Provider<DockManager> dockManagerProvider,
      Provider<Handler> mainHandlerProvider) {
    return new LockIcon_Factory(
        contextProvider,
        attrsProvider,
        statusBarStateControllerProvider,
        configurationControllerProvider,
        accessibilityControllerProvider,
        keyguardMonitorProvider,
        dockManagerProvider,
        mainHandlerProvider);
  }

  public static LockIcon newLockIcon(
      Context context,
      AttributeSet attrs,
      StatusBarStateController statusBarStateController,
      ConfigurationController configurationController,
      AccessibilityController accessibilityController,
      KeyguardMonitor keyguardMonitor,
      DockManager dockManager,
      Handler mainHandler) {
    return new LockIcon(
        context,
        attrs,
        statusBarStateController,
        configurationController,
        accessibilityController,
        keyguardMonitor,
        dockManager,
        mainHandler);
  }
}
