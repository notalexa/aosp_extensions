// Generated by Dagger (https://google.github.io/dagger).
package com.android.systemui.statusbar.notification;

import dagger.internal.Factory;

public final class NotificationFilter_Factory implements Factory<NotificationFilter> {
  private static final NotificationFilter_Factory INSTANCE = new NotificationFilter_Factory();

  @Override
  public NotificationFilter get() {
    return provideInstance();
  }

  public static NotificationFilter provideInstance() {
    return new NotificationFilter();
  }

  public static NotificationFilter_Factory create() {
    return INSTANCE;
  }

  public static NotificationFilter newNotificationFilter() {
    return new NotificationFilter();
  }
}
