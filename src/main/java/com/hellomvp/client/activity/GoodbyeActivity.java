package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hellomvp.client.ui.GoodbyeViewImpl;

public class GoodbyeActivity extends AbstractActivity {
  // Name that will be appended to "Good-bye, "
  private final String name;

  public GoodbyeActivity(String name) {
    this.name = name;
  }

  @Override
  public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    GoodbyeViewImpl goodbyeView = new GoodbyeViewImpl();
    goodbyeView.setName(name);
    containerWidget.setWidget(goodbyeView.asWidget());
  }
}
