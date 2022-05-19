package com.example.planet.repository;

import com.example.planet.entity.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

  List<Satellite> findByPlanetId(Long planetId);
}
