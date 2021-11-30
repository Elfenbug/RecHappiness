package ru.ibs.rechappiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
