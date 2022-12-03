// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar;

import android.content.Context;
import android.os.Handler;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NavigationBarController_Factory implements Factory<NavigationBarController> {
  private final Provider<Context> contextProvider;

  private final Provider<Handler> handlerProvider;

  public NavigationBarController_Factory(
      Provider<Context> contextProvider, Provider<Handler> handlerProvider) {
    this.contextProvider = contextProvider;
    this.handlerProvider = handlerProvider;
  }

  @Override
  public NavigationBarController get() {
    return provideInstance(contextProvider, handlerProvider);
  }

  public static NavigationBarController provideInstance(
      Provider<Context> contextProvider, Provider<Handler> handlerProvider) {
    return new NavigationBarController(contextProvider.get(), handlerProvider.get());
  }

  public static NavigationBarController_Factory create(
      Provider<Context> contextProvider, Provider<Handler> handlerProvider) {
    return new NavigationBarController_Factory(contextProvider, handlerProvider);
  }

  public static NavigationBarController newNavigationBarController(
      Context context, Handler handler) {
    return new NavigationBarController(context, handler);
  }
}