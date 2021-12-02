package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.KindDevelop;

public interface KindDevelopRepository extends JpaRepository<KindDevelop, Long> {
}
