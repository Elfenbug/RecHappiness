package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
