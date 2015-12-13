package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.HelloViewImpl;

public class HelloActivity extends AbstractActivity implements
    HelloView.Presenter {
  // Name that will be appended to "Hello,"
  private String name;
  private PlaceController placeController;

  public HelloActivity(HelloPlace place, PlaceController placeController) {
    this.name = place.getHelloName();
    this.placeController = placeController;
  }

  /**
   * Invoked by the ActivityManager to start a new Activity
   */
  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    HelloView helloView = HelloViewImpl.create();
    helloView.setName(name);
    helloView.setPresenter(this);
    containerWidget.setWidget(helloView.asWidget());
  }

  /**
   * Navigate to a new Place in the browser
   */
  public void goTo(Place place) {
    placeController.goTo(place);
  }
}
