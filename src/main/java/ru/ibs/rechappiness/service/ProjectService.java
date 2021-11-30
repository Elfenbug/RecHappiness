package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.entity.Project;

import java.util.List;

public interface ProjectService {
    Project getById(Long id);

    void save(Project customer);

    void delete(Long id);

    List<Project> getAll();
}
