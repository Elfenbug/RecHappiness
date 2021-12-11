package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.KindDevelopDto;
import ru.ibs.rechappiness.model.KindDevelop;

@Mapper
public interface KindDevelopMapper {
    KindDevelopMapper INSTANCE = Mappers.getMapper(KindDevelopMapper.class);

    KindDevelop toKindDevelop(KindDevelopDto kindDevelopDto);

    @InheritInverseConfiguration
    KindDevelopDto fromKindDevelop(KindDevelop kindDevelop);
}
