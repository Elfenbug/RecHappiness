package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Interviewer;

import java.util.List;

public interface InterviewerService {

    Interviewer getInterviewer(Long id);

    void saveInterviewer(Interviewer interviewer);

    void deleteInterviewer(Long id);

    List<Interviewer> getAllInterviewers();

    void updateInterviewer(Interviewer interviewer, Long id);
}
