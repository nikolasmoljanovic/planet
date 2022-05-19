package com.example.planet.controller;

import com.example.planet.dto.PlanetDto;
import com.example.planet.dto.PlanetSaveDto;
import com.example.planet.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("planet")
public class PlanetController {

  private final PlanetService planetService;

  @PostMapping
  public PlanetDto save(@RequestBody PlanetSaveDto planetSaveDto) {
    return planetService.save(planetSaveDto);
  }

  @PutMapping
  public PlanetDto update(@RequestBody PlanetDto planetDto) {
    return planetService.update(planetDto);
  }

  @GetMapping
  public PlanetDto findById(@RequestParam Long id) {
    return planetService.findById(id);
  }

  @DeleteMapping
  public PlanetDto deleteById(@RequestParam Long id) {
    return planetService.deleteById(id);
  }

  @GetMapping("paging")
  public Page<PlanetDto> findByName(Pageable pageable, @RequestParam String name) {
    return planetService.findByNamePaging(pageable, name);
  }

  @GetMapping("paging-sorted")
  public Page<PlanetDto> findAllSortedBySatellitesCount(Pageable pageable) {
    return planetService.findAllSortedBySatellitesCount(pageable);
  }
}
