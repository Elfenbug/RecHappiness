package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
