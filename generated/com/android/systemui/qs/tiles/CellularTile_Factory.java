// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.qs.tiles;

import com.android.systemui.plugins.ActivityStarter;
import com.android.systemui.qs.QSHost;
import com.android.systemui.statusbar.policy.NetworkController;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CellularTile_Factory implements Factory<CellularTile> {
  private final Provider<QSHost> hostProvider;

  private final Provider<NetworkController> networkControllerProvider;

  private final Provider<ActivityStarter> activityStarterProvider;

  public CellularTile_Factory(
      Provider<QSHost> hostProvider,
      Provider<NetworkController> networkControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    this.hostProvider = hostProvider;
    this.networkControllerProvider = networkControllerProvider;
    this.activityStarterProvider = activityStarterProvider;
  }

  @Override
  public CellularTile get() {
    return provideInstance(hostProvider, networkControllerProvider, activityStarterProvider);
  }

  public static CellularTile provideInstance(
      Provider<QSHost> hostProvider,
      Provider<NetworkController> networkControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    return new CellularTile(
        hostProvider.get(), networkControllerProvider.get(), activityStarterProvider.get());
  }

  public static CellularTile_Factory create(
      Provider<QSHost> hostProvider,
      Provider<NetworkController> networkControllerProvider,
      Provider<ActivityStarter> activityStarterProvider) {
    return new CellularTile_Factory(
        hostProvider, networkControllerProvider, activityStarterProvider);
  }

  public static CellularTile newCellularTile(
      QSHost host, NetworkController networkController, ActivityStarter activityStarter) {
    return new CellularTile(host, networkController, activityStarter);
  }
}
