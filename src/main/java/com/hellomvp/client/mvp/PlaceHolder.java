package com.hellomvp.client.mvp;

import com.google.gwt.place.shared.Place;

public class PlaceHolder {

  private Place currentPlace;

  public Place getCurrentPlace() {
    return currentPlace;
  }

  void setCurrentPlace(Place place) {
    currentPlace = place;
  }

}
