package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.ProjectTypeDto;
import ru.ibs.rechappiness.mapper.ProjectTypeMapper;
import ru.ibs.rechappiness.model.ProjectType;
import ru.ibs.rechappiness.repository.ProjectTypeRepository;
import ru.ibs.rechappiness.service.ProjectTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProjectTypeServiceImpl implements ProjectTypeService {

    private final ProjectTypeRepository  projectTypeRepository;

    public ProjectTypeServiceImpl(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    @Override
    public List<ProjectTypeDto> getAllProjectTypes() {
        log.info("IN ProjectTypeServiceImpl getAllProjectTypes");
        List<ProjectTypeDto> projectTypeDtoList = new ArrayList<>();
        List<ProjectType> projectTypeList = projectTypeRepository.findAll();
        for (ProjectType projectTypes : projectTypeList) {
            projectTypeDtoList.add(ProjectTypeMapper.INSTANCE.fromProjectType(projectTypes));
        }
        return projectTypeDtoList;
    }

    @Override
    public ProjectTypeDto getProjectType(Long id) {
        log.info("IN ProjectTypeServiceImpl getProjectType {}", id);
        return ProjectTypeMapper.INSTANCE.fromProjectType(projectTypeRepository.findById(id).orElse(null));
    }

    @Override
    public void saveProjectType(ProjectTypeDto projectTypeDto) {
        log.info("IN ProjectTypeServiceImpl saveProjectType {}", projectTypeDto);
        projectTypeRepository.save(ProjectTypeMapper.INSTANCE.toProjectType(projectTypeDto));
    }

    @Override
    public void deleteProjectType(Long id) {
        log.info("IN ProjectTypeServiceImpl deleteProjectType {}", id);
        projectTypeRepository.deleteById(id);
    }

    @Override
    public void updateProjectType(ProjectTypeDto projectTypeDto, Long id) {
        log.info("IN ProjectTypeServiceImpl updateProjectType {}", projectTypeDto);
        if (projectTypeRepository.findById(id).orElse(null) != null) {
            projectTypeDto.setId(id);
            projectTypeRepository.save(ProjectTypeMapper.INSTANCE.toProjectType(projectTypeDto));
        }
    }

}
