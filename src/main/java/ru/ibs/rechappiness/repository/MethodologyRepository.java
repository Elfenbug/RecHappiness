package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Methodology;

public interface MethodologyRepository extends JpaRepository<Methodology, Long> {
}
