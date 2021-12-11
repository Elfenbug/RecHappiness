package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.OvertimeDto;
import ru.ibs.rechappiness.model.Overtime;

@Mapper
public interface OvertimeMapper {
    OvertimeMapper INSTANCE = Mappers.getMapper(OvertimeMapper.class);

    Overtime toOvertime(OvertimeDto overtimeDto);

    @InheritInverseConfiguration
    OvertimeDto fromOvertime(Overtime overtime);
}
