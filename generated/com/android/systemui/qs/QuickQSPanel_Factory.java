// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.qs;

import android.content.Context;
import android.util.AttributeSet;
import com.android.systemui.DumpController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class QuickQSPanel_Factory implements Factory<QuickQSPanel> {
  private final Provider<Context> contextProvider;

  private final Provider<AttributeSet> attrsProvider;

  private final Provider<DumpController> dumpControllerProvider;

  public QuickQSPanel_Factory(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<DumpController> dumpControllerProvider) {
    this.contextProvider = contextProvider;
    this.attrsProvider = attrsProvider;
    this.dumpControllerProvider = dumpControllerProvider;
  }

  @Override
  public QuickQSPanel get() {
    return provideInstance(contextProvider, attrsProvider, dumpControllerProvider);
  }

  public static QuickQSPanel provideInstance(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<DumpController> dumpControllerProvider) {
    return new QuickQSPanel(
        contextProvider.get(), attrsProvider.get(), dumpControllerProvider.get());
  }

  public static QuickQSPanel_Factory create(
      Provider<Context> contextProvider,
      Provider<AttributeSet> attrsProvider,
      Provider<DumpController> dumpControllerProvider) {
    return new QuickQSPanel_Factory(contextProvider, attrsProvider, dumpControllerProvider);
  }

  public static QuickQSPanel newQuickQSPanel(
      Context context, AttributeSet attrs, DumpController dumpController) {
    return new QuickQSPanel(context, attrs, dumpController);
  }
}