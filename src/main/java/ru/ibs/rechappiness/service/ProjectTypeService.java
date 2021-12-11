package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.ProjectTypeDto;

import java.util.List;

public interface ProjectTypeService {

    ProjectTypeDto getProjectType(Long id);

    void saveProjectType(ProjectTypeDto projectTypeDto);

    void deleteProjectType(Long id);

    List<ProjectTypeDto> getAllProjectTypes();

    void updateProjectType(ProjectTypeDto projectTypeDto, Long id);
}
