package com.example.planet.exception.notfound;

public class PlanetNotFoundByNameException extends ResourceNotFoundException {

  public PlanetNotFoundByNameException(String name) {
    super("Planet not found by name: " + name);
  }
}
