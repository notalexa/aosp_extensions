// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.util.leak;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LeakReporter_Factory implements Factory<LeakReporter> {
  private final Provider<Context> contextProvider;

  private final Provider<LeakDetector> leakDetectorProvider;

  private final Provider<String> leakReportEmailProvider;

  public LeakReporter_Factory(
      Provider<Context> contextProvider,
      Provider<LeakDetector> leakDetectorProvider,
      Provider<String> leakReportEmailProvider) {
    this.contextProvider = contextProvider;
    this.leakDetectorProvider = leakDetectorProvider;
    this.leakReportEmailProvider = leakReportEmailProvider;
  }

  @Override
  public LeakReporter get() {
    return provideInstance(contextProvider, leakDetectorProvider, leakReportEmailProvider);
  }

  public static LeakReporter provideInstance(
      Provider<Context> contextProvider,
      Provider<LeakDetector> leakDetectorProvider,
      Provider<String> leakReportEmailProvider) {
    return new LeakReporter(
        contextProvider.get(), leakDetectorProvider.get(), leakReportEmailProvider.get());
  }

  public static LeakReporter_Factory create(
      Provider<Context> contextProvider,
      Provider<LeakDetector> leakDetectorProvider,
      Provider<String> leakReportEmailProvider) {
    return new LeakReporter_Factory(contextProvider, leakDetectorProvider, leakReportEmailProvider);
  }

  public static LeakReporter newLeakReporter(
      Context context, LeakDetector leakDetector, String leakReportEmail) {
    return new LeakReporter(context, leakDetector, leakReportEmail);
  }
}