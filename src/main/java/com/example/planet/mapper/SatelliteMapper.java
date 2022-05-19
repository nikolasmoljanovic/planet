package com.example.planet.mapper;

import com.example.planet.dto.SatelliteDto;
import com.example.planet.dto.SatelliteSaveDto;
import com.example.planet.entity.Satellite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SatelliteMapper {

  SatelliteDto toDto(Satellite satellite);

  Satellite toEntity(SatelliteDto satelliteDto);

  Satellite toEntity(SatelliteSaveDto satelliteSaveDto);
}
