package ru.ibs.rechappiness.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.model.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDto toDto(Project project);

    List<ProjectDto> map(List<Project> projects);
}
