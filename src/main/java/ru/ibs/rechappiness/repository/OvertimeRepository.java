package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Overtime;

public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
}
