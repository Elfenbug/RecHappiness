package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.ParticipantDto;

import java.util.List;

public interface ParticipantService {

    ParticipantDto getParticipant(Long id);

    void saveParticipant(ParticipantDto participantDto);

    void deleteParticipant(Long id);

    List<ParticipantDto> getAllParticipants();

    void updateParticipant(ParticipantDto participantDto, Long id);
}
