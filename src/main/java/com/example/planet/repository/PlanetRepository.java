package com.example.planet.repository;

import com.example.planet.entity.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

  Optional<Planet> findByName(String name);

  Page<Planet> findByName(Pageable pageable, String name);

  @Query(
      value =
          "(select p.id, p.name, p.surface_area, p.mass, p.distance_from_sun, p.average_surface_temperature "
              + "from satellite s join planet p on s.planet_id = p.id "
              + "group by p.id, p.name, p.mass, p.surface_area , p.distance_from_sun , p.average_surface_temperature "
              + "order by count(*) desc)",
      nativeQuery = true)
  Page<Planet> findAllSortedBySatellitesCount(Pageable pageable);
}
