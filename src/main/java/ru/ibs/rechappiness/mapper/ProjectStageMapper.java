package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ProjectStageDto;
import ru.ibs.rechappiness.model.ProjectStage;

@Mapper
public interface ProjectStageMapper {
    ProjectStageMapper INSTANCE = Mappers.getMapper(ProjectStageMapper.class);

    ProjectStage toProjectStage(ProjectStageDto projectStageDto);

    @InheritInverseConfiguration
    ProjectStageDto fromProjectStage(ProjectStage projectStage);
}
