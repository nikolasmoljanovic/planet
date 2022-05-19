package com.example.planet.exception.badrequest;

public class IdNotProvidedException extends ResourceBadRequestException {

  public IdNotProvidedException() {
    super("Please provide an id of the planet that you are trying to update");
  }
}
