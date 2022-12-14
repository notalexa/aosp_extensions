// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import android.content.Context;
import com.android.systemui.statusbar.policy.ConfigurationController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DependencyProvider_ProvideConfigurationControllerFactory
    implements Factory<ConfigurationController> {
  private final DependencyProvider module;

  private final Provider<Context> contextProvider;

  public DependencyProvider_ProvideConfigurationControllerFactory(
      DependencyProvider module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public ConfigurationController get() {
    return provideInstance(module, contextProvider);
  }

  public static ConfigurationController provideInstance(
      DependencyProvider module, Provider<Context> contextProvider) {
    return proxyProvideConfigurationController(module, contextProvider.get());
  }

  public static DependencyProvider_ProvideConfigurationControllerFactory create(
      DependencyProvider module, Provider<Context> contextProvider) {
    return new DependencyProvider_ProvideConfigurationControllerFactory(module, contextProvider);
  }

  public static ConfigurationController proxyProvideConfigurationController(
      DependencyProvider instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideConfigurationController(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
