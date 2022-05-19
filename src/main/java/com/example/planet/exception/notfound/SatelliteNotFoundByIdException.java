package com.example.planet.exception.notfound;

public class SatelliteNotFoundByIdException extends ResourceNotFoundException {

  public SatelliteNotFoundByIdException(Long id) {
    super("Satellite not found by id: " + id);
  }
}
