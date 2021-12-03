package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectStage;

import java.util.List;

public interface ProjectStageService {

    ProjectStage getProjectStage(Long id);

    void saveProjectStage(ProjectStage projectStage);

    void deleteProjectStage(Long id);

    List<ProjectStage> getAllProjectStages();

    void updateProjectStage(ProjectStage projectStage, Long id);
}
