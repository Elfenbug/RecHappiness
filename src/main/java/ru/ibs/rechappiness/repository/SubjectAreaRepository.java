package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.SubjectArea;

public interface SubjectAreaRepository extends JpaRepository<SubjectArea, Long> {
}
