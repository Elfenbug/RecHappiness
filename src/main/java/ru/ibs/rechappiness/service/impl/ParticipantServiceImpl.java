package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Participant;
import ru.ibs.rechappiness.repository.ParticipantRepository;
import ru.ibs.rechappiness.service.ParticipantService;

import java.util.List;

@Service
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public List<Participant> getAllParticipants() {
        log.info("IN ParticipantServiceImpl getAllParticipants");
        return participantRepository.findAll();
    }

    @Override
    public Participant getParticipant(Long id) {
        log.info("IN ParticipantServiceImpl getParticipant {}", id);
        return participantRepository.findById(id).orElse(null);
    }

    @Override
    public void saveParticipant(Participant participant) {
        log.info("IN ParticipantServiceImpl saveParticipant {}", participant);
        participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(Long id) {
        log.info("IN ParticipantServiceImpl deleteParticipant {}", id);
        participantRepository.deleteById(id);
    }

    @Override
    public void updateParticipant(Participant participant, Long id) {
        log.info("IN ParticipantServiceImpl updateParticipant {}", participant);
        if (participantRepository.findById(id).orElse(null) != null) {
            participant.setId(id);
            participantRepository.save(participant);
        }
    }
}
