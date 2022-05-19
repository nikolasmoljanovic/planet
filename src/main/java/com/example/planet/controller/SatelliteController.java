package com.example.planet.controller;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;
import com.example.planet.service.SatelliteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("satellite")
public class SatelliteController {

  private final SatelliteService satelliteService;

  @PostMapping
  public SatelliteDto save(@RequestBody SatelliteSaveDto satelliteSaveDto) {
    return satelliteService.save(satelliteSaveDto);
  }

  @GetMapping
  public SatelliteDto findById(@RequestParam Long id) {
    return satelliteService.findById(id);
  }

  @GetMapping("by-planet")
  public List<SatelliteDto> findByPlanetId(@RequestParam Long planetId) {
    return satelliteService.findByPlanetId(planetId);
  }

  @DeleteMapping
  public SatelliteDto deleteById(@RequestParam Long id) {
    return satelliteService.deleteById(id);
  }

  @PutMapping
  public SatelliteDto update(@RequestBody SatelliteDto satelliteDto) {
    return satelliteService.update(satelliteDto);
  }
}
