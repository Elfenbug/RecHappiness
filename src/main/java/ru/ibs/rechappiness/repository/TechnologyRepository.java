package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
