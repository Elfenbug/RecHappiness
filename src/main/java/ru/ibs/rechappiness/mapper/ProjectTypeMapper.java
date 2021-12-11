package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ProjectTypeDto;
import ru.ibs.rechappiness.model.ProjectType;

@Mapper
public interface ProjectTypeMapper {
    ProjectTypeMapper INSTANCE = Mappers.getMapper(ProjectTypeMapper.class);

    ProjectType toProjectType(ProjectTypeDto projectTypeDto);

    @InheritInverseConfiguration
    ProjectTypeDto fromProjectType(ProjectType projectType);
}
