package com.example.planet.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SatelliteSaveDto {

  private String name;
  private Long surfaceArea;
  private Long mass;
  private Boolean naturalSatellite;
  private PlanetSaveDto planet;
}
