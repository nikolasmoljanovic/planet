package com.example.planet.controller;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "/test.properties")
public class SatelliteControllerIntegrationTest {

  private final SatelliteController satelliteController;

  @Autowired
  public SatelliteControllerIntegrationTest(SatelliteController satelliteController) {
    this.satelliteController = satelliteController;
  }

  @Test
  void save() {
    SatelliteDto result =
        satelliteController.save(
            SatelliteSaveDto.builder()
                .naturalSatellite(true)
                .name("Satellite-1")
                .mass(123L)
                .surfaceArea(456L)
                .build());

    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(1L);
    assertThat(result.getName()).isEqualTo("Satellite-1");
  }
}
