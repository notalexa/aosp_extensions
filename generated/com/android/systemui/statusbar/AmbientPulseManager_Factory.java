// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AmbientPulseManager_Factory implements Factory<AmbientPulseManager> {
  private final Provider<Context> contextProvider;

  public AmbientPulseManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AmbientPulseManager get() {
    return provideInstance(contextProvider);
  }

  public static AmbientPulseManager provideInstance(Provider<Context> contextProvider) {
    return new AmbientPulseManager(contextProvider.get());
  }

  public static AmbientPulseManager_Factory create(Provider<Context> contextProvider) {
    return new AmbientPulseManager_Factory(contextProvider);
  }

  public static AmbientPulseManager newAmbientPulseManager(Context context) {
    return new AmbientPulseManager(context);
  }
}
