package com.example.planet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PlanetDto {

  private Long id;
  private String name;
  private Long surfaceArea;
  private Long mass;
  private Long distanceFromSun;
  private Integer averageSurfaceTemperature;
  private List<SatelliteDto> satellites;
}
