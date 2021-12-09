package ru.ibs.rechappiness.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.LocationDto;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.model.Location;
import ru.ibs.rechappiness.model.Project;

import java.util.List;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

//    Location toLocation(LocationDto locationDto);
//
//    @InheritInverseConfiguration
//    LocationDto fromLocation(Location location);

    LocationDto toDto(Location location);

    List<LocationDto> map(List<Location> location);
}
