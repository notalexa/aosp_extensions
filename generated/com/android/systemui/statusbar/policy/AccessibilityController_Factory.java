// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.policy;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AccessibilityController_Factory implements Factory<AccessibilityController> {
  private final Provider<Context> contextProvider;

  public AccessibilityController_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AccessibilityController get() {
    return provideInstance(contextProvider);
  }

  public static AccessibilityController provideInstance(Provider<Context> contextProvider) {
    return new AccessibilityController(contextProvider.get());
  }

  public static AccessibilityController_Factory create(Provider<Context> contextProvider) {
    return new AccessibilityController_Factory(contextProvider);
  }

  public static AccessibilityController newAccessibilityController(Context context) {
    return new AccessibilityController(context);
  }
}