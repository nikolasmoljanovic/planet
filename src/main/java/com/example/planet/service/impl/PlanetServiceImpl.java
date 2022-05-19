package com.example.planet.service.impl;

import com.example.planet.dto.PlanetDto;
import com.example.planet.dto.PlanetSaveDto;
import com.example.planet.entity.Planet;
import com.example.planet.exception.badrequest.IdNotProvidedException;
import com.example.planet.exception.notfound.PlanetNotFoundByIdException;
import com.example.planet.mapper.PlanetMapper;
import com.example.planet.repository.PlanetRepository;
import com.example.planet.repository.SatelliteRepository;
import com.example.planet.service.PlanetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class PlanetServiceImpl implements PlanetService {

  private final PlanetRepository planetRepository;
  private final SatelliteRepository satelliteRepository;
  private final PlanetMapper planetMapper;

  @Override
  public PlanetDto save(PlanetSaveDto planetSaveDto) {
    log.info("Saving planet with name {}", planetSaveDto.getName());
    return planetMapper.toDto(planetRepository.save(planetMapper.toEntity(planetSaveDto)));
  }

  @Override
  public PlanetDto findById(Long id) {
    log.info("Finding planet by id: {}", id);
    return planetMapper.toDto(
        planetRepository.findById(id).orElseThrow(() -> new PlanetNotFoundByIdException(id)));
  }

  @Override
  public Page<PlanetDto> findByNamePaging(Pageable pageable, String name) {
    return planetRepository.findByName(pageable, name).map(planetMapper::toDto);
  }

  @Override
  public Page<PlanetDto> findAllSortedBySatellitesCount(Pageable pageable) {
    return planetRepository.findAllSortedBySatellitesCount(pageable).map(planetMapper::toDto);
  }

  @Override
  public PlanetDto update(PlanetDto planetDto) {
    Long id = planetDto.getId();
    if (id == null) {
      throw new IdNotProvidedException();
    }
    if (planetRepository.findById(id).isEmpty()) {
      log.error("Planet with id: {} does not exists", id);
      throw new PlanetNotFoundByIdException(id);
    }
    return planetMapper.toDto(planetRepository.save(planetMapper.toEntity(planetDto)));
  }

  @Override
  public PlanetDto deleteById(Long id) {
    Optional<Planet> planet = planetRepository.findById(id);
    if (planet.isEmpty()) {
      throw new PlanetNotFoundByIdException(id);
    }
    planetRepository.deleteById(id);
    return planetMapper.toDto(planet.get());
  }
}
