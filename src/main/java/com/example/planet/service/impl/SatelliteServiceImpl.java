package com.example.planet.service.impl;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;
import com.example.planet.entity.Satellite;
import com.example.planet.exception.badrequest.IdNotProvidedException;
import com.example.planet.exception.notfound.SatelliteNotFoundByIdException;
import com.example.planet.mapper.SatelliteMapper;
import com.example.planet.repository.SatelliteRepository;
import com.example.planet.service.SatelliteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SatelliteServiceImpl implements SatelliteService {

  private final SatelliteRepository satelliteRepository;
  private final SatelliteMapper satelliteMapper;

  @Override
  public SatelliteDto save(SatelliteSaveDto satelliteSaveDto) {
    return satelliteMapper.toDto(
        satelliteRepository.save(satelliteMapper.toEntity(satelliteSaveDto)));
  }

  @Override
  public SatelliteDto findById(Long id) {
    return satelliteMapper.toDto(
        satelliteRepository.findById(id).orElseThrow(() -> new SatelliteNotFoundByIdException(id)));
  }

  @Override
  public List<SatelliteDto> findByPlanetId(Long planetId) {
    return satelliteRepository.findByPlanetId(planetId).stream()
        .map(satelliteMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public SatelliteDto deleteById(Long id) {
    Optional<Satellite> satellite = satelliteRepository.findById(id);
    if (satellite.isEmpty()) {
      throw new SatelliteNotFoundByIdException(id);
    }
    satelliteRepository.deleteById(id);
    return satelliteMapper.toDto(satellite.get());
  }

  @Override
  public SatelliteDto update(SatelliteDto satelliteDto) {
    Long id = satelliteDto.getId();
    if (id == null) {
      throw new IdNotProvidedException();
    }
    if (satelliteRepository.findById(id).isEmpty()) {
      log.error("Satellite with id: {} does not exists", id);
      throw new SatelliteNotFoundByIdException(id);
    }
    return satelliteMapper.toDto(satelliteRepository.save(satelliteMapper.toEntity(satelliteDto)));
  }
}
