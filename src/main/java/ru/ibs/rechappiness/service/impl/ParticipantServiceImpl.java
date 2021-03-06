package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.ParticipantDto;
import ru.ibs.rechappiness.mapper.ParticipantMapper;
import ru.ibs.rechappiness.model.Participant;
import ru.ibs.rechappiness.repository.ParticipantRepository;
import ru.ibs.rechappiness.service.ParticipantService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public List<ParticipantDto> getAllParticipants() {
        log.info("IN ParticipantServiceImpl getAllParticipants");
        List<ParticipantDto> participantDtoList = new ArrayList<>();
        List<Participant> participantList = participantRepository.findAll();
        for (Participant participants : participantList) {
            participantDtoList.add(ParticipantMapper.INSTANCE.fromParticipant(participants));
        }
        return participantDtoList;
    }

    @Override
    public ParticipantDto getParticipant(Long id) {
        log.info("IN ParticipantServiceImpl getParticipant {}", id);
        return ParticipantMapper.INSTANCE.fromParticipant(participantRepository.findById(id).orElse(null));
    }

    @Override
    public void saveParticipant(ParticipantDto participantDto) {
        log.info("IN ParticipantServiceImpl saveParticipant {}", participantDto);
        participantRepository.save(ParticipantMapper.INSTANCE.toParticipant(participantDto));
    }

    @Override
    public void deleteParticipant(Long id) {
        log.info("IN ParticipantServiceImpl deleteParticipant {}", id);
        participantRepository.deleteById(id);
    }

    @Override
    public void updateParticipant(ParticipantDto participantDto, Long id) {
        log.info("IN ParticipantServiceImpl updateParticipant {}", participantDto);
        if (participantRepository.findById(id).orElse(null) != null) {
            participantDto.setId(id);
            participantRepository.save(ParticipantMapper.INSTANCE.toParticipant(participantDto));
        }
    }
}
