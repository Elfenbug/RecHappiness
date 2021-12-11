package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.InterviewerDto;
import ru.ibs.rechappiness.mapper.InterviewerMapper;
import ru.ibs.rechappiness.model.Interviewer;
import ru.ibs.rechappiness.repository.InterviewerRepository;
import ru.ibs.rechappiness.service.InterviewerService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InterviewerServiceImpl implements InterviewerService {

    private final InterviewerRepository interviewerRepository;

    public InterviewerServiceImpl(InterviewerRepository interviewerRepository) {
        this.interviewerRepository = interviewerRepository;
    }

    @Override
    public List<InterviewerDto> getAllInterviewers() {
        log.info("IN InterviewerServiceImpl getAllInterviewers");
        List<InterviewerDto> interviewerDtoList = new ArrayList<>();
        List<Interviewer> interviewerList = interviewerRepository.findAll();
        for (Interviewer interviewers : interviewerList) {
            interviewerDtoList.add(InterviewerMapper.INSTANCE.fromInterviewer(interviewers));
        }
        return interviewerDtoList;
    }

    @Override
    public InterviewerDto getInterviewer(Long id) {
        log.info("IN InterviewerServiceImpl getInterviewer {}", id);
        return InterviewerMapper.INSTANCE.fromInterviewer(interviewerRepository.findById(id).orElse(null));
    }

    @Override
    public void saveInterviewer(InterviewerDto interviewerDto) {
        log.info("IN InterviewerServiceImpl saveInterviewer {}", interviewerDto);
        interviewerRepository.save(InterviewerMapper.INSTANCE.toInterviewer(interviewerDto));
    }

    @Override
    public void deleteInterviewer(Long id) {
        log.info("IN InterviewerServiceImpl deleteInterviewer {}", id);
        interviewerRepository.deleteById(id);
    }

    @Override
    public void updateInterviewer(InterviewerDto interviewerDto, Long id) {
        log.info("IN InterviewerServiceImpl updateInterviewer {}", interviewerDto);
        if (interviewerRepository.findById(id).orElse(null) != null) {
            interviewerDto.setId(id);
            interviewerRepository.save(InterviewerMapper.INSTANCE.toInterviewer(interviewerDto));
        }
    }

}
