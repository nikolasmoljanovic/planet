package com.example.planet.service;

import com.example.planet.dto.PlanetDto;
import com.example.planet.dto.PlanetSaveDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanetService {

  PlanetDto save(PlanetSaveDto planetSaveDto);

  PlanetDto findById(Long id);

  Page<PlanetDto> findByNamePaging(Pageable pageable, String name);

  Page<PlanetDto> findAllSortedBySatellitesCount(Pageable pageable);

  PlanetDto update(PlanetDto planetDto);

  PlanetDto deleteById(Long id);
}
