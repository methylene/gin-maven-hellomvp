package com.hellomvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.hellomvp.client.mvp.AppActivityMapper;
import com.hellomvp.client.mvp.AppPlaceHistoryMapper;
import com.hellomvp.client.place.HelloPlace;

public class AppLoader {

  @Inject
  private AppWidget appWidget;

  @Inject
  private PlaceController placeController;

  @Inject
  private PlaceHistoryHandler historyHandler;

  @Inject
  private ActivityManager activityManager;

  @Inject
  private ActivityMapper activityMapper;

  @Inject
  private EventBus eventBus;


  public void loadApp() {
    activityManager.setDisplay(appWidget);
    RootPanel.get().add(appWidget);
    historyHandler.handleCurrentHistory();
  }

}
