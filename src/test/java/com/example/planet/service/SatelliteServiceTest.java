package com.example.planet.service;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;
import com.example.planet.entity.Satellite;
import com.example.planet.exception.notfound.ResourceNotFoundException;
import com.example.planet.mapper.SatelliteMapper;
import com.example.planet.repository.SatelliteRepository;
import com.example.planet.service.impl.SatelliteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SatelliteServiceTest {

  @Mock private SatelliteRepository satelliteRepository;
  @Mock private SatelliteMapper satelliteMapper;

  @InjectMocks SatelliteServiceImpl satelliteService;

  private Satellite satellite;
  private SatelliteDto satelliteDto;
  private SatelliteSaveDto satelliteSaveDto;

  @BeforeEach
  public void setup() {
    satelliteDto =
        SatelliteDto.builder()
            .id(1L)
            .naturalSatellite(true)
            .name("Satellite-1")
            .mass(123L)
            .surfaceArea(456L)
            .build();

    satellite =
        Satellite.builder()
            .id(1L)
            .naturalSatellite(true)
            .name("Satellite-1")
            .mass(123L)
            .surfaceArea(456L)
            .build();

    satelliteSaveDto =
        SatelliteSaveDto.builder()
            .naturalSatellite(true)
            .name("Satellite-1")
            .mass(123L)
            .surfaceArea(456L)
            .build();
  }

  @Test
  public void save() {
    given(satelliteRepository.save(satellite)).willReturn(satellite);
    given(satelliteMapper.toDto(satellite)).willReturn(satelliteDto);
    given(satelliteMapper.toEntity(satelliteSaveDto)).willReturn(satellite);

    SatelliteDto result = satelliteService.save(satelliteSaveDto);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(1L);
  }

  @Test
  public void findById() {
    given(satelliteRepository.findById(1L)).willReturn(Optional.of(satellite));
    given(satelliteMapper.toDto(satellite)).willReturn(satelliteDto);

    SatelliteDto result = satelliteService.findById(1L);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(1L);
  }

  @Test
  public void findByIdException404() {
    given(satelliteRepository.findById(1L)).willReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> satelliteService.findById(1L));
  }
}
