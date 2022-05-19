package com.example.planet.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetSaveDto {

  private String name;
  private Long surfaceArea;
  private Long mass;
  private Long distanceFromSun;
  private Integer averageSurfaceTemperature;
  private List<SatelliteSaveDto> satellites;
}
