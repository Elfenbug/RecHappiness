package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.TechnologyDto;
import ru.ibs.rechappiness.model.Technology;

@Mapper
public interface TechnologyMapper {
    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);

    TechnologyDto fromTechnology(Technology technology);

    @InheritInverseConfiguration
    Technology toTechnology(TechnologyDto technologyDto);
}
