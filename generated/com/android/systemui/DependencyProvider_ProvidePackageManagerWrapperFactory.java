// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import com.android.systemui.shared.system.PackageManagerWrapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DependencyProvider_ProvidePackageManagerWrapperFactory
    implements Factory<PackageManagerWrapper> {
  private final DependencyProvider module;

  public DependencyProvider_ProvidePackageManagerWrapperFactory(DependencyProvider module) {
    this.module = module;
  }

  @Override
  public PackageManagerWrapper get() {
    return provideInstance(module);
  }

  public static PackageManagerWrapper provideInstance(DependencyProvider module) {
    return proxyProvidePackageManagerWrapper(module);
  }

  public static DependencyProvider_ProvidePackageManagerWrapperFactory create(
      DependencyProvider module) {
    return new DependencyProvider_ProvidePackageManagerWrapperFactory(module);
  }

  public static PackageManagerWrapper proxyProvidePackageManagerWrapper(
      DependencyProvider instance) {
    return Preconditions.checkNotNull(
        instance.providePackageManagerWrapper(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
