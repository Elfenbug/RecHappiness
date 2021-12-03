package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectType;

import java.util.List;

public interface ProjectTypeService {

    ProjectType getProjectType(Long id);

    void saveProjectType(ProjectType ProjectType);

    void deleteProjectType(Long id);

    List<ProjectType> getAllProjectTypes();

    void updateProjectType(ProjectType projectType, Long id);
}
