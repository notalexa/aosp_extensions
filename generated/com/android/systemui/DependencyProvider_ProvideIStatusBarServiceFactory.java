// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import com.android.internal.statusbar.IStatusBarService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DependencyProvider_ProvideIStatusBarServiceFactory
    implements Factory<IStatusBarService> {
  private final DependencyProvider module;

  public DependencyProvider_ProvideIStatusBarServiceFactory(DependencyProvider module) {
    this.module = module;
  }

  @Override
  public IStatusBarService get() {
    return provideInstance(module);
  }

  public static IStatusBarService provideInstance(DependencyProvider module) {
    return proxyProvideIStatusBarService(module);
  }

  public static DependencyProvider_ProvideIStatusBarServiceFactory create(
      DependencyProvider module) {
    return new DependencyProvider_ProvideIStatusBarServiceFactory(module);
  }

  public static IStatusBarService proxyProvideIStatusBarService(DependencyProvider instance) {
    return Preconditions.checkNotNull(
        instance.provideIStatusBarService(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
