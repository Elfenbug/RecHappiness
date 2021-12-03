package ru.ibs.rechappiness.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Interviewer;
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
    public List<Interviewer> showAllInterviewers() {
        return interviewerService.getAllInterviewers();
    }

    @GetMapping("/interviewer/read/{id}")
    public Interviewer getInterviewer(@PathVariable Long id) {
        return interviewerService.getInterviewer(id);
    }

    @PostMapping("/interviewer/create")
    public Interviewer addNewInterviewer(@RequestBody Interviewer interviewer) {
        interviewerService.saveInterviewer(interviewer);
        return interviewer;
    }

    @PostMapping("/interviewer/update/{id}")
    public void updateInterviewer(@RequestBody Interviewer interviewer, @PathVariable Long id) {
        interviewerService.updateInterviewer(interviewer, id);
    }

    @PostMapping("/interviewer/update/")
    public Interviewer updateInterviewer() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/interviewer/delete/{id}")
    public String deleteInterviewer(@PathVariable Long id) {
        interviewerService.deleteInterviewer(id);
        return "interviewer with ID = " + id + " was deleted";
    }

    @PostMapping("/interviewer/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
