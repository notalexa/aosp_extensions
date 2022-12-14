// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.fragments;

import com.android.systemui.SystemUIFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FragmentService_Factory implements Factory<FragmentService> {
  private final Provider<SystemUIFactory.SystemUIRootComponent> rootComponentProvider;

  public FragmentService_Factory(
      Provider<SystemUIFactory.SystemUIRootComponent> rootComponentProvider) {
    this.rootComponentProvider = rootComponentProvider;
  }

  @Override
  public FragmentService get() {
    return provideInstance(rootComponentProvider);
  }

  public static FragmentService provideInstance(
      Provider<SystemUIFactory.SystemUIRootComponent> rootComponentProvider) {
    return new FragmentService(rootComponentProvider.get());
  }

  public static FragmentService_Factory create(
      Provider<SystemUIFactory.SystemUIRootComponent> rootComponentProvider) {
    return new FragmentService_Factory(rootComponentProvider);
  }

  public static FragmentService newFragmentService(
      SystemUIFactory.SystemUIRootComponent rootComponent) {
    return new FragmentService(rootComponent);
  }
}
