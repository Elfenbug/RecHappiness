package ru.ibs.rechappiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
