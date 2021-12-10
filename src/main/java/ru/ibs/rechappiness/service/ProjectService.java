package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto getProject(Long id);

    void saveProject(ProjectDto project);

    void deleteProject(Long id);

    List<ProjectDto> getAllProjects();

    void updateProject(ProjectDto projectDto, Long id);

}
