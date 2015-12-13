package com.hellomvp.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UsersPlace extends Place {

  public UsersPlace() {

  }

  public static class Tokenizer implements PlaceTokenizer<UsersPlace> {
    // TODO: * PARSE PARAMS TO A MULTIVALUEDMAP; * ENCODE TO BASE64

    @Override
    public String getToken(UsersPlace place) {
      // TODO: test return null !!!
      return "";
    }

    @Override
    public UsersPlace getPlace(String token) {
      return new UsersPlace();
    }
  }

}
