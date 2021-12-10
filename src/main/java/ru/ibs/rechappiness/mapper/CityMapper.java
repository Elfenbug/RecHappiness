package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.CityDto;
import ru.ibs.rechappiness.model.City;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City toCity(CityDto cityDto);

    @InheritInverseConfiguration
    CityDto fromCity(City city);
}
