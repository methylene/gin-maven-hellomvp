package com.hellomvp.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.UsersPlace;

public class HelloViewImpl extends Composite implements HelloView {
//  private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

  interface HelloViewImplUiBinder extends UiBinder<Widget, HelloViewImpl> {
  }

  @UiField
  DivElement nameSpan;

  @UiField
  Anchor goodbyeLink;
  private Presenter listener;

  public static HelloViewImpl create() {
    HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);
    HelloViewImpl impl = new HelloViewImpl();
    Widget widget = uiBinder.createAndBindUi(impl);
    impl.initWidget(widget);
    return impl;
  }

  @Override
  public void setName(String name) {
    nameSpan.setInnerText(name);
  }

//  http://rest.db.ripe.net/ripe/inetnum/64.233.162.94.json

  @UiHandler("goodbyeLink")
  void onClickGoodbye(ClickEvent e) {
    listener.goTo(new GoodbyePlace(nameSpan.getInnerText()));
  }

  @Override
  public void setPresenter(Presenter listener) {
    this.listener = listener;
  }
}
