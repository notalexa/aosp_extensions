// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.policy;

import android.content.Context;
import android.os.Handler;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HotspotControllerImpl_Factory implements Factory<HotspotControllerImpl> {
  private final Provider<Context> contextProvider;

  private final Provider<Handler> mainHandlerProvider;

  public HotspotControllerImpl_Factory(
      Provider<Context> contextProvider, Provider<Handler> mainHandlerProvider) {
    this.contextProvider = contextProvider;
    this.mainHandlerProvider = mainHandlerProvider;
  }

  @Override
  public HotspotControllerImpl get() {
    return provideInstance(contextProvider, mainHandlerProvider);
  }

  public static HotspotControllerImpl provideInstance(
      Provider<Context> contextProvider, Provider<Handler> mainHandlerProvider) {
    return new HotspotControllerImpl(contextProvider.get(), mainHandlerProvider.get());
  }

  public static HotspotControllerImpl_Factory create(
      Provider<Context> contextProvider, Provider<Handler> mainHandlerProvider) {
    return new HotspotControllerImpl_Factory(contextProvider, mainHandlerProvider);
  }

  public static HotspotControllerImpl newHotspotControllerImpl(
      Context context, Handler mainHandler) {
    return new HotspotControllerImpl(context, mainHandler);
  }
}