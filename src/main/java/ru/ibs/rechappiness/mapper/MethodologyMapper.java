package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.MethodologyDto;
import ru.ibs.rechappiness.model.Methodology;

@Mapper
public interface MethodologyMapper {
    MethodologyMapper INSTANCE = Mappers.getMapper(MethodologyMapper.class);

    Methodology toMethodology(MethodologyDto methodologyDto);

    @InheritInverseConfiguration
    MethodologyDto fromMethodology(Methodology methodology);
}
