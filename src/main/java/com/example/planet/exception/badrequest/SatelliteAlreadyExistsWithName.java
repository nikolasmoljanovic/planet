package com.example.planet.exception.badrequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SatelliteAlreadyExistsWithName extends ResourceBadRequestException {

  public SatelliteAlreadyExistsWithName(String name) {
    super("Satellite already exists with name: " + name);
  }
}
