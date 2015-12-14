package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.mvp.PlaceHolder;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.ui.GoodbyeViewImpl;

import javax.inject.Inject;

public class GoodbyeActivity extends AbstractActivity {

  @Inject
  private PlaceHolder placeHolder;

  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    GoodbyeViewImpl goodbyeView = new GoodbyeViewImpl();
    GoodbyePlace currentPlace = (GoodbyePlace) placeHolder.getCurrentPlace();
    goodbyeView.setName(currentPlace.getGoodbyeName());
    containerWidget.setWidget(goodbyeView.asWidget());
  }
}
