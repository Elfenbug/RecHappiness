package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.FunctionalDirection;

public interface FunctionDirectionRepository extends JpaRepository<FunctionalDirection, Long> {
}
