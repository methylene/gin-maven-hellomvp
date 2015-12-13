package com.hellomvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;

public class AppActivityMapper implements ActivityMapper {

  @Inject
  private PlaceController placeController;

  /**
   * Map each Place to its corresponding Activity. This would be a great use
   * for GIN.
   */
  @Override
  public Activity getActivity(Place place) {
    // This is begging for GIN
    if (place instanceof HelloPlace)
      return new HelloActivity((HelloPlace) place, placeController);
    else if (place instanceof GoodbyePlace)
      return new GoodbyeActivity(((GoodbyePlace) place).getGoodbyeName());

    return null;
  }

}
