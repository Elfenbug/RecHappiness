package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.SubjectAreaDto;
import ru.ibs.rechappiness.model.SubjectArea;

@Mapper
public interface SubjectAreaMapper {
    SubjectAreaMapper INSTANCE = Mappers.getMapper(SubjectAreaMapper.class);

    SubjectArea toSubjectArea(SubjectAreaDto subjectAreaDto);

    @InheritInverseConfiguration
    SubjectAreaDto fromSubjectArea(SubjectArea subjectArea);
}
