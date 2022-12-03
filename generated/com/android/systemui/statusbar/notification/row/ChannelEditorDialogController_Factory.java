// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.notification.row;

import android.app.INotificationManager;
import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ChannelEditorDialogController_Factory
    implements Factory<ChannelEditorDialogController> {
  private final Provider<Context> cProvider;

  private final Provider<INotificationManager> noManProvider;

  public ChannelEditorDialogController_Factory(
      Provider<Context> cProvider, Provider<INotificationManager> noManProvider) {
    this.cProvider = cProvider;
    this.noManProvider = noManProvider;
  }

  @Override
  public ChannelEditorDialogController get() {
    return provideInstance(cProvider, noManProvider);
  }

  public static ChannelEditorDialogController provideInstance(
      Provider<Context> cProvider, Provider<INotificationManager> noManProvider) {
    return new ChannelEditorDialogController(cProvider.get(), noManProvider.get());
  }

  public static ChannelEditorDialogController_Factory create(
      Provider<Context> cProvider, Provider<INotificationManager> noManProvider) {
    return new ChannelEditorDialogController_Factory(cProvider, noManProvider);
  }

  public static ChannelEditorDialogController newChannelEditorDialogController(
      Context c, INotificationManager noMan) {
    return new ChannelEditorDialogController(c, noMan);
  }
}
