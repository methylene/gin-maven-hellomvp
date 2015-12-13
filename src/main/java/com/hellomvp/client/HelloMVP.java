package com.hellomvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.hellomvp.client.mvp.AppActivityMapper;
import com.hellomvp.client.mvp.AppPlaceHistoryMapper;
import com.hellomvp.client.place.HelloPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloMVP implements EntryPoint {
  private Place defaultPlace = new HelloPlace("World!");
  private SimplePanel appWidget = new SimplePanel();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    // Create ClientFactory using deferred binding so we can replace with different
    // impls in gwt.xml
    MyGinjector injector = GWT.create(MyGinjector.class);
    AppLoader appLoader = injector.getAppLoader();
    appLoader.loadApp();
//    EventBus eventBus = new SimpleEventBus();
//    PlaceController placeController = new PlaceController(eventBus);
//
//    ActivityMapper activityMapper = new AppActivityMapper(placeController);
//    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
//    activityManager.setDisplay(appWidget);
//
//    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
//    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
//    historyHandler.register(placeController, eventBus, defaultPlace);
//
//    RootPanel.get().add(appWidget);
//    historyHandler.handleCurrentHistory();
  }
}
