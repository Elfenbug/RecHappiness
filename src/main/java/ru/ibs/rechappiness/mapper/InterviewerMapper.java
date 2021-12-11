package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.InterviewerDto;
import ru.ibs.rechappiness.model.Interviewer;

@Mapper
public interface InterviewerMapper {
    InterviewerMapper INSTANCE = Mappers.getMapper(InterviewerMapper.class);

    Interviewer toInterviewer(InterviewerDto interviewerDto);

    @InheritInverseConfiguration
    InterviewerDto fromInterviewer(Interviewer interviewer);
}
