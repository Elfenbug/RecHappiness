package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.entity.Project;
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
    public Project getById(Long id) {
        return null;
    }

    @Override
    public void save(Project customer) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Project> getAll() {
        return null;
    }
}
