package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {
}
