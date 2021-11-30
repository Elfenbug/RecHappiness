package ru.ibs.rechappiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.rechappiness.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
