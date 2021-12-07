package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
