package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.ProjectStageDto;
import ru.ibs.rechappiness.mapper.ProjectStageMapper;
import ru.ibs.rechappiness.model.ProjectStage;
import ru.ibs.rechappiness.repository.ProjectStageRepository;
import ru.ibs.rechappiness.service.ProjectStageService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProjectStageServiceImpl implements ProjectStageService {
    private final ProjectStageRepository projectStageRepository;

    public ProjectStageServiceImpl(ProjectStageRepository projectStageRepository) {
        this.projectStageRepository = projectStageRepository;
    }

    @Override
    public List<ProjectStageDto> getAllProjectStages() {
        log.info("IN ProjectStageServiceImpl getAllProjectStages");
        List<ProjectStageDto> projectStageDtoList = new ArrayList<>();
        List<ProjectStage> projectStageList = projectStageRepository.findAll();
        for (ProjectStage projectStages : projectStageList) {
            projectStageDtoList.add(ProjectStageMapper.INSTANCE.fromProjectStage(projectStages));
        }
        return projectStageDtoList;
    }

    @Override
    public ProjectStageDto getProjectStage(Long id) {
        log.info("IN ProjectStageServiceImpl getProjectStageService {}", id);
        return ProjectStageMapper.INSTANCE.fromProjectStage(projectStageRepository.findById(id).orElse(null));
    }

    @Override
    public void saveProjectStage(ProjectStageDto projectStageDto) {
        log.info("IN ProjectStageServiceImpl saveProjectStage {}", projectStageDto);
        projectStageRepository.save(ProjectStageMapper.INSTANCE.toProjectStage(projectStageDto));
    }

    @Override
    public void deleteProjectStage(Long id) {
        log.info("IN ProjectStageServiceImpl deleteProjectStage {}", id);
        projectStageRepository.deleteById(id);
    }

    @Override
    public void updateProjectStage(ProjectStageDto projectStageDto, Long id) {
        log.info("IN ProjectStageServiceImpl updateProjectStage {}", projectStageDto);
        if (projectStageRepository.findById(id).orElse(null) != null) {
            projectStageDto.setId(id);
            projectStageRepository.save(ProjectStageMapper.INSTANCE.toProjectStage(projectStageDto));
        }
    }
}
