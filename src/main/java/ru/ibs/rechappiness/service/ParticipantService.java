package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Participant;

import java.util.List;

public interface ParticipantService {

    Participant getParticipant(Long id);

    void saveParticipant(Participant participant);

    void deleteParticipant(Long id);

    List<Participant> getAllParticipants();

    void updateParticipant(Participant participant, Long id);
}
