package com.example.planet.service;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;

import java.util.List;

public interface SatelliteService {

  SatelliteDto save(SatelliteSaveDto satelliteSaveDto);

  SatelliteDto findById(Long id);

  List<SatelliteDto> findByPlanetId(Long planetId);

  SatelliteDto deleteById(Long id);

  SatelliteDto update(SatelliteDto satelliteDto);
}
