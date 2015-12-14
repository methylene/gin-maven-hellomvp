package com.hellomvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.mvp.AppActivityMapper;
import com.hellomvp.client.mvp.AppPlaceHistoryMapper;
import com.hellomvp.client.mvp.PlaceHolder;
import com.hellomvp.client.place.HelloPlace;

import javax.inject.Singleton;

public class MyGinModule extends AbstractGinModule {

  public static class MyPlaceControllerProvider implements Provider<PlaceController> {

    @Inject
    public MyPlaceControllerProvider(EventBus eventBus) {
      this.instance = new PlaceController(eventBus);
    }

    private final PlaceController instance;

    @Override
    public PlaceController get() {
      return instance;
    }
  }

  public static class MyActivityManagerProvider implements Provider<ActivityManager> {

    @Inject
    public MyActivityManagerProvider(EventBus eventBus, ActivityMapper activityMapper) {
      this.instance = new ActivityManager(activityMapper, eventBus);
    }

    private final ActivityManager instance;

    @Override
    public ActivityManager get() {
      return instance;
    }
  }

  public static class MyPlaceHistoryHandlerProvider implements Provider<PlaceHistoryHandler> {

    static AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

    private final PlaceHistoryHandler instance;

    @Inject
    public MyPlaceHistoryHandlerProvider(PlaceController placeController, EventBus eventBus) {
      this.instance = new PlaceHistoryHandler(historyMapper);
      this.instance.register(placeController, eventBus, new HelloPlace("World!"));
    }

    @Override
    public PlaceHistoryHandler get() {
      return instance;
    }
  }

  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(PlaceController.class).toProvider(MyPlaceControllerProvider.class).in(Singleton.class);
    bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
    bind(ActivityManager.class).toProvider(MyActivityManagerProvider.class).in(Singleton.class);
    bind(PlaceHistoryHandler.class).toProvider(MyPlaceHistoryHandlerProvider.class).in(Singleton.class);
    bind(AppWidget.class).in(Singleton.class);
    bind(PlaceHolder.class).in(Singleton.class);
    bind(HelloActivity.class).in(Singleton.class);
    bind(GoodbyeActivity.class).in(Singleton.class);
  }

}
