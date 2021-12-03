package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectStage;
import ru.ibs.rechappiness.repository.ProjectRepository;
import ru.ibs.rechappiness.repository.ProjectStageRepository;
import ru.ibs.rechappiness.service.ProjectService;
import ru.ibs.rechappiness.service.ProjectStageService;

import java.util.List;

@Service
@Slf4j
public class ProjectStageServiceImpl implements ProjectStageService {

    private final ProjectStageRepository projectStageRepository;

    public ProjectStageServiceImpl(ProjectStageRepository projectStageRepository) {
        this.projectStageRepository = projectStageRepository;
    }

    @Override
    public List<ProjectStage> getAllProjectStages() {
        log.info("IN ProjectStageServiceImpl getAllProjectStages");
        return projectStageRepository.findAll();
    }

    @Override
    public ProjectStage getProjectStage(Long id) {
        log.info("IN ProjectStageServiceImpl getProjectStageService {}", id);
        return projectStageRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProjectStage(ProjectStage projectStage) {
        log.info("IN ProjectStageServiceImpl saveProjectStage {}", projectStage);
        projectStageRepository.save(projectStage);
    }

    @Override
    public void deleteProjectStage(Long id) {
        log.info("IN ProjectStageServiceImpl deleteProjectStage {}", id);
        projectStageRepository.deleteById(id);
    }

    @Override
    public void updateProjectStage(ProjectStage projectStage, Long id) {
        log.info("IN ProjectStageServiceImpl updateProjectStage {}", projectStage);
        if (projectStageRepository.findById(id).orElse(null) != null) {
            projectStage.setId(id);
            projectStageRepository.save(projectStage);
        }
    }
}
