// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.qs.tiles;

import com.android.systemui.plugins.ActivityStarter;
import com.android.systemui.qs.QSHost;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AirplaneModeTile_Factory implements Factory<AirplaneModeTile> {
  private final Provider<QSHost> hostProvider;

  private final Provider<ActivityStarter> activityStarterProvider;

  public AirplaneModeTile_Factory(
      Provider<QSHost> hostProvider, Provider<ActivityStarter> activityStarterProvider) {
    this.hostProvider = hostProvider;
    this.activityStarterProvider = activityStarterProvider;
  }

  @Override
  public AirplaneModeTile get() {
    return provideInstance(hostProvider, activityStarterProvider);
  }

  public static AirplaneModeTile provideInstance(
      Provider<QSHost> hostProvider, Provider<ActivityStarter> activityStarterProvider) {
    return new AirplaneModeTile(hostProvider.get(), activityStarterProvider.get());
  }

  public static AirplaneModeTile_Factory create(
      Provider<QSHost> hostProvider, Provider<ActivityStarter> activityStarterProvider) {
    return new AirplaneModeTile_Factory(hostProvider, activityStarterProvider);
  }

  public static AirplaneModeTile newAirplaneModeTile(QSHost host, ActivityStarter activityStarter) {
    return new AirplaneModeTile(host, activityStarter);
  }
}
