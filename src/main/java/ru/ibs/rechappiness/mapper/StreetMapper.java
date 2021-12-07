package ru.ibs.rechappiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.model.Street;

import java.util.List;

@Mapper
public interface StreetMapper {
    StreetMapper INSTANCE = Mappers.getMapper(StreetMapper.class);

    StreetDto toDto(Street street);

    List<StreetDto> map(List<Street> streets);
}
