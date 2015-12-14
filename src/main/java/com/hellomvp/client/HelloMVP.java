package com.hellomvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.SimplePanel;
import com.hellomvp.client.place.HelloPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloMVP implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    MyGinjector injector = GWT.create(MyGinjector.class);
    AppLoader appLoader = injector.getAppLoader();
    appLoader.loadApp();
  }

}
