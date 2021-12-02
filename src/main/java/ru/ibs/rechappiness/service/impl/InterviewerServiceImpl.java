package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Interviewer;
import ru.ibs.rechappiness.repository.InterviewerRepository;
import ru.ibs.rechappiness.service.InterviewerService;

import java.util.List;

@Service
@Slf4j
public class InterviewerServiceImpl implements InterviewerService {

    private final InterviewerRepository interviewerRepository;

    public InterviewerServiceImpl(InterviewerRepository interviewerRepository) {
        this.interviewerRepository = interviewerRepository;
    }

    @Override
    public List<Interviewer> getAllInterviewers() {
        log.info("IN InterviewerServiceImpl getAllInterviewers");
        return interviewerRepository.findAll();
    }

    @Override
    public Interviewer getInterviewer(Long id) {
        log.info("IN InterviewerServiceImpl getInterviewer {}", id);
        return interviewerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveInterviewer(Interviewer interviewer) {
        log.info("IN InterviewerServiceImpl saveInterviewer {}", interviewer);
        interviewerRepository.save(interviewer);
    }

    @Override
    public void deleteInterviewer(Long id) {
        log.info("IN InterviewerServiceImpl deleteInterviewer {}", id);
        interviewerRepository.deleteById(id);
    }

    @Override
    public void updateInterviewer(Interviewer interviewer, Long id) {
        log.info("IN InterviewerServiceImpl updateInterviewer {}", interviewer);
        if (interviewerRepository.findById(id).orElse(null) != null) {
            interviewer.setId(id);
            interviewerRepository.save(interviewer);
        }
    }

}
