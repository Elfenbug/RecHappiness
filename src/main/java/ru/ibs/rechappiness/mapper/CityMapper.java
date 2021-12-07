package ru.ibs.rechappiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.CityDto;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Street;

import java.util.List;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto toDto(City city);

    List<CityDto> map(List<City> cities);
}
