package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
