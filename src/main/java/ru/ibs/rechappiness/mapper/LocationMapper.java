package ru.ibs.rechappiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.LocationDto;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.model.Location;
import ru.ibs.rechappiness.model.Street;

import java.util.List;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDto toDto(Location location);

    List<LocationDto> map(List<Location> location);
}