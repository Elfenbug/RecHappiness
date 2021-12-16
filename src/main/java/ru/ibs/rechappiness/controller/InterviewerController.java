package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.InterviewerDto;
import ru.ibs.rechappiness.service.InterviewerService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class InterviewerController {

    private final InterviewerService interviewerService;

    public InterviewerController(InterviewerService interviewerService) {
        this.interviewerService = interviewerService;
    }

    @GetMapping("/interviewer/read")
    public List<InterviewerDto> showAllInterviewers() {
        return interviewerService.getAllInterviewers();
    }

    @GetMapping("/interviewer/read/{id}")
    public InterviewerDto getInterviewer(@PathVariable Long id) {
        return interviewerService.getInterviewer(id);
    }

    @PostMapping("/interviewer/create")
    public void addNewInterviewer(@RequestBody InterviewerDto interviewerDto) {
        interviewerService.saveInterviewer(interviewerDto);
    }

    @PostMapping("/interviewer/update/{id}")
    public void updateInterviewer(@RequestBody InterviewerDto interviewerDto, @PathVariable Long id) {
        interviewerService.updateInterviewer(interviewerDto, id);
    }

    @PostMapping("/interviewer/delete/{id}")
    public String deleteInterviewer(@PathVariable Long id) {
        interviewerService.deleteInterviewer(id);
        return "interviewer with ID = " + id + " was deleted";
    }
}
