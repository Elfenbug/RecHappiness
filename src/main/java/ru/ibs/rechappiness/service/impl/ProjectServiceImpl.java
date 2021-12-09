package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.dto.TechnologyDto;
import ru.ibs.rechappiness.mapper.ProjectMapper;
import ru.ibs.rechappiness.mapper.TechnologyMapper;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Project;
import ru.ibs.rechappiness.model.Technology;
import ru.ibs.rechappiness.repository.ProjectRepository;
import ru.ibs.rechappiness.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<ProjectDto> getAllProjects() {
        log.info("IN ProjectServiceImpl getAllProjects");

        List<ProjectDto> projectDtoList = new ArrayList<>();
        List<Project> projectList = projectRepository.findAll();
        for (Project projects : projectList) {
            projectDtoList.add(ProjectMapper.INSTANCE.fromProject(projects));
        }
        return projectDtoList;

        //return projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        log.info("IN ProjectServiceImpl getProject {}", id);
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProject(Project project) {
        log.info("IN ProjectServiceImpl saveProject {}", project);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        log.info("IN ProjectServiceImpl deleteProject {}", id);
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(Project project, Long id) {
        log.info("IN CustomerServiceImpl updateProject {}", project);
        if (projectRepository.findById(id).orElse(null) != null) {
            project.setId(id);
            projectRepository.save(project);
        }
    }


}
