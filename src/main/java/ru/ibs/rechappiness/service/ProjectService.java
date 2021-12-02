package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project getById(Long id);

    void save(Project project);

    void delete(Long id);

    void updateProject(Project project, Long id);

}
