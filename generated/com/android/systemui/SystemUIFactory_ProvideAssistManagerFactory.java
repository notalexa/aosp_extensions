// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import android.content.Context;
import com.android.systemui.assist.AssistManager;
import com.android.systemui.statusbar.policy.DeviceProvisionedController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SystemUIFactory_ProvideAssistManagerFactory implements Factory<AssistManager> {
  private final SystemUIFactory module;

  private final Provider<DeviceProvisionedController> controllerProvider;

  private final Provider<Context> contextProvider;

  public SystemUIFactory_ProvideAssistManagerFactory(
      SystemUIFactory module,
      Provider<DeviceProvisionedController> controllerProvider,
      Provider<Context> contextProvider) {
    this.module = module;
    this.controllerProvider = controllerProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public AssistManager get() {
    return provideInstance(module, controllerProvider, contextProvider);
  }

  public static AssistManager provideInstance(
      SystemUIFactory module,
      Provider<DeviceProvisionedController> controllerProvider,
      Provider<Context> contextProvider) {
    return proxyProvideAssistManager(module, controllerProvider.get(), contextProvider.get());
  }

  public static SystemUIFactory_ProvideAssistManagerFactory create(
      SystemUIFactory module,
      Provider<DeviceProvisionedController> controllerProvider,
      Provider<Context> contextProvider) {
    return new SystemUIFactory_ProvideAssistManagerFactory(
        module, controllerProvider, contextProvider);
  }

  public static AssistManager proxyProvideAssistManager(
      SystemUIFactory instance, DeviceProvisionedController controller, Context context) {
    return Preconditions.checkNotNull(
        instance.provideAssistManager(controller, context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
