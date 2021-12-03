package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Project;

import java.util.List;

public interface ProjectService {

    Project getProject(Long id);

    void saveProject(Project project);

    void deleteProject(Long id);

    List<Project> getAllProjects();

    void updateProject(Project project, Long id);

}
