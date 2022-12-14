// Generated by Dagger (https://google.github.io/dagger).
package com.android.keyguard;

import android.content.Context;
import android.util.AttributeSet;
import com.android.systemui.statusbar.policy.ConfigurationController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class KeyguardMessageArea_Factory implements Factory<KeyguardMessageArea> {
  private final Provider<Context> contextProvider;

  private final Provider<AttributeSet> attrsProvider;

  private final Provider<ConfigurationController> configurationControllerProvider;

  public KeyguardMessageArea_Factory(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<ConfigurationController> configurationControllerProvider) {
    this.contextProvider = contextProvider;
    this.attrsProvider = attrsProvider;
    this.configurationControllerProvider = configurationControllerProvider;
  }

  @Override
  public KeyguardMessageArea get() {
    return provideInstance(contextProvider, attrsProvider, configurationControllerProvider);
  }

  public static KeyguardMessageArea provideInstance(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<ConfigurationController> configurationControllerProvider) {
    return new KeyguardMessageArea(
        contextProvider.get(), attrsProvider.get(), configurationControllerProvider.get());
  }

  public static KeyguardMessageArea_Factory create(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<ConfigurationController> configurationControllerProvider) {
    return new KeyguardMessageArea_Factory(
        contextProvider, attrsProvider, configurationControllerProvider);
  }

  public static KeyguardMessageArea newKeyguardMessageArea(
      Context context, AttributeSet attrs, ConfigurationController configurationController) {
    return new KeyguardMessageArea(context, attrs, configurationController);
  }
}
