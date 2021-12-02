package ru.ibs.rechappiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {
}
