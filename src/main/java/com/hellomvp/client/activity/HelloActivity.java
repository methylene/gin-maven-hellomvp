package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.mvp.PlaceHolder;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;
import com.hellomvp.client.ui.HelloView;
import com.hellomvp.client.ui.HelloViewImpl;

import javax.inject.Inject;

public class HelloActivity extends AbstractActivity implements
    HelloView.Presenter {

  @Inject
  private PlaceController placeController;

  @Inject
  private PlaceHolder placeHolder;

  /**
   * Invoked by the ActivityManager to start a new Activity
   */
  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    HelloView helloView = HelloViewImpl.create();
    HelloPlace currentPlace = (HelloPlace) placeHolder.getCurrentPlace();
    helloView.setName(currentPlace.getHelloName());
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
