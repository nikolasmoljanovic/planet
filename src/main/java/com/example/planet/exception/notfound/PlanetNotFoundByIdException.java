package com.example.planet.exception.notfound;

public class PlanetNotFoundByIdException extends ResourceNotFoundException {

  public PlanetNotFoundByIdException(Long id) {
    super("Planet not found by id: " + id);
  }
}
