package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.FunctionalDirectionDto;
import ru.ibs.rechappiness.model.FunctionalDirection;

@Mapper
public interface FunctionalDirectionMapper {
    FunctionalDirectionMapper INSTANCE = Mappers.getMapper(FunctionalDirectionMapper.class);

    FunctionalDirection toFunctionalDirection(FunctionalDirectionDto functionalDirectionDto);

    @InheritInverseConfiguration
    FunctionalDirectionDto fromFunctionalDirection(FunctionalDirection functionalDirection);
}
