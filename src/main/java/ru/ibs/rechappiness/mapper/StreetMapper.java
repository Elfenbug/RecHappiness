package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.model.Street;

@Mapper
public interface StreetMapper {
    StreetMapper INSTANCE = Mappers.getMapper(StreetMapper.class);

    Street toStreet(StreetDto streetDto);

    @InheritInverseConfiguration
    StreetDto fromStreet(Street street);
}
