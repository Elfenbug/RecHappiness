package ru.ibs.rechappiness.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.model.Project;

import java.util.List;

@Mapper(uses = {LocationMapper.class, TechnologyMapper.class})
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toProject(ProjectDto projectDto);

    @InheritInverseConfiguration
    @Mapping(target = "technologies", ignore = true)
    ProjectDto fromProject(Project project);


    // ProjectDto toDto(Project project);

   // List<ProjectDto> mapList(List<Project> projects);
}
