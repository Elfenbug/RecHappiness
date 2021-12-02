package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Project;
import ru.ibs.rechappiness.repository.ProjectRepository;
import ru.ibs.rechappiness.service.ProjectService;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(Project project, Long id) {
        if (projectRepository.findById(id).orElse(null) != null) {
            project.setId(id);
            projectRepository.save(project);
        }
    }


}
