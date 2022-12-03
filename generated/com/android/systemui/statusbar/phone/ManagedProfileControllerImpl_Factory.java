// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.phone;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ManagedProfileControllerImpl_Factory
    implements Factory<ManagedProfileControllerImpl> {
  private final Provider<Context> contextProvider;

  public ManagedProfileControllerImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ManagedProfileControllerImpl get() {
    return provideInstance(contextProvider);
  }

  public static ManagedProfileControllerImpl provideInstance(Provider<Context> contextProvider) {
    return new ManagedProfileControllerImpl(contextProvider.get());
  }

  public static ManagedProfileControllerImpl_Factory create(Provider<Context> contextProvider) {
    return new ManagedProfileControllerImpl_Factory(contextProvider);
  }

  public static ManagedProfileControllerImpl newManagedProfileControllerImpl(Context context) {
    return new ManagedProfileControllerImpl(context);
  }
}