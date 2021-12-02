package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
