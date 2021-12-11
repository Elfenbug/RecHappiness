package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.InterviewerDto;

import java.util.List;

public interface InterviewerService {

    InterviewerDto getInterviewer(Long id);

    void saveInterviewer(InterviewerDto interviewerDto);

    void deleteInterviewer(Long id);

    List<InterviewerDto> getAllInterviewers();

    void updateInterviewer(InterviewerDto interviewerDto, Long id);
}
