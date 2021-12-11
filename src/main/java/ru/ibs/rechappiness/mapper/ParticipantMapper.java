package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ParticipantDto;
import ru.ibs.rechappiness.model.Participant;

@Mapper
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    Participant toParticipant(ParticipantDto participantDto);

    @InheritInverseConfiguration
    ParticipantDto fromParticipant(Participant participant);
}
