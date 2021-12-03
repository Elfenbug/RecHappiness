package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectType;
import ru.ibs.rechappiness.repository.ProjectTypeRepository;
import ru.ibs.rechappiness.service.ProjectTypeService;

import java.util.List;

@Service
@Slf4j
public class ProjectTypeServiceImpl implements ProjectTypeService {

    private final ProjectTypeRepository  projectTypeRepository;

    public ProjectTypeServiceImpl(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    @Override
    public List<ProjectType> getAllProjectTypes() {
        log.info("IN ProjectTypeServiceImpl getAllProjectTypes");
        return projectTypeRepository.findAll();
    }

    @Override
    public ProjectType getProjectType(Long id) {
        log.info("IN ProjectTypeServiceImpl getProjectType {}", id);
        return projectTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProjectType(ProjectType projectType) {
        log.info("IN ProjectTypeServiceImpl saveProjectType {}", projectType);
        projectTypeRepository.save(projectType);
    }

    @Override
    public void deleteProjectType(Long id) {
        log.info("IN ProjectTypeServiceImpl deleteProjectType {}", id);
        projectTypeRepository.deleteById(id);
    }

    @Override
    public void updateProjectType(ProjectType projectType, Long id) {
        log.info("IN ProjectTypeServiceImpl updateProjectType {}", projectType);
        if (projectTypeRepository.findById(id).orElse(null) != null) {
            projectType.setId(id);
            projectTypeRepository.save(projectType);
        }
    }

}
