package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.ProjectStageDto;

import java.util.List;

public interface ProjectStageService {

    ProjectStageDto getProjectStage(Long id);

    void saveProjectStage(ProjectStageDto projectStageDto);

    void deleteProjectStage(Long id);

    List<ProjectStageDto> getAllProjectStages();

    void updateProjectStage(ProjectStageDto projectStageDto, Long id);
}
