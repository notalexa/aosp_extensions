// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import android.os.Handler;
import android.os.Looper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DependencyProvider_ProvideBgHandlerFactory implements Factory<Handler> {
  private final DependencyProvider module;

  private final Provider<Looper> bgLooperProvider;

  public DependencyProvider_ProvideBgHandlerFactory(
      DependencyProvider module, Provider<Looper> bgLooperProvider) {
    this.module = module;
    this.bgLooperProvider = bgLooperProvider;
  }

  @Override
  public Handler get() {
    return provideInstance(module, bgLooperProvider);
  }

  public static Handler provideInstance(
      DependencyProvider module, Provider<Looper> bgLooperProvider) {
    return proxyProvideBgHandler(module, bgLooperProvider.get());
  }

  public static DependencyProvider_ProvideBgHandlerFactory create(
      DependencyProvider module, Provider<Looper> bgLooperProvider) {
    return new DependencyProvider_ProvideBgHandlerFactory(module, bgLooperProvider);
  }

  public static Handler proxyProvideBgHandler(DependencyProvider instance, Looper bgLooper) {
    return Preconditions.checkNotNull(
        instance.provideBgHandler(bgLooper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}