package com.example.planet.mapper;

import com.example.planet.dto.PlanetDto;
import com.example.planet.dto.PlanetSaveDto;
import com.example.planet.entity.Planet;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {SatelliteMapper.class})
public interface PlanetMapper {

  PlanetDto toDto(Planet planet);

  Planet toEntity(PlanetDto planetDto);

  PlanetSaveDto toSaveDto(Planet planet);

  Planet toEntity(PlanetSaveDto planetSaveDto);
}
