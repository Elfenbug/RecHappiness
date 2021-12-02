package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.ProjectStage;

public interface ProjectStageRepository extends JpaRepository<ProjectStage, Long> {
}
