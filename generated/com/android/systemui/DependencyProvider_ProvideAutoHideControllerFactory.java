// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui;

import android.content.Context;
import android.os.Handler;
import com.android.systemui.statusbar.phone.AutoHideController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DependencyProvider_ProvideAutoHideControllerFactory
    implements Factory<AutoHideController> {
  private final DependencyProvider module;

  private final Provider<Context> contextProvider;

  private final Provider<Handler> mainHandlerProvider;

  public DependencyProvider_ProvideAutoHideControllerFactory(
      DependencyProvider module,
      Provider<Context> contextProvider,
      Provider<Handler> mainHandlerProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
    this.mainHandlerProvider = mainHandlerProvider;
  }

  @Override
  public AutoHideController get() {
    return provideInstance(module, contextProvider, mainHandlerProvider);
  }

  public static AutoHideController provideInstance(
      DependencyProvider module,
      Provider<Context> contextProvider,
      Provider<Handler> mainHandlerProvider) {
    return proxyProvideAutoHideController(module, contextProvider.get(), mainHandlerProvider.get());
  }

  public static DependencyProvider_ProvideAutoHideControllerFactory create(
      DependencyProvider module,
      Provider<Context> contextProvider,
      Provider<Handler> mainHandlerProvider) {
    return new DependencyProvider_ProvideAutoHideControllerFactory(
        module, contextProvider, mainHandlerProvider);
  }

  public static AutoHideController proxyProvideAutoHideController(
      DependencyProvider instance, Context context, Handler mainHandler) {
    return Preconditions.checkNotNull(
        instance.provideAutoHideController(context, mainHandler),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
