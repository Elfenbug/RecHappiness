package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.SubjectArea;
import ru.ibs.rechappiness.service.SubjectAreaService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class SubjectAreaController {

    private final SubjectAreaService subjectAreaService;


    public SubjectAreaController(SubjectAreaService subjectAreaService) {
        this.subjectAreaService = subjectAreaService;
    }

    @GetMapping("/subjectarea/read")
    public List<SubjectArea> showAllSubjectAreas() {
        return subjectAreaService.getAllSubjectAreas();
    }

    @GetMapping("/subjectarea/read/{id}")
    public SubjectArea getSubjectArea(@PathVariable Long id) {
        return subjectAreaService.getSubjectArea(id);
    }

    @PostMapping("/subjectarea/create")
    public SubjectArea addNewSubjectArea(@RequestBody SubjectArea subjectArea) {
        subjectAreaService.saveSubjectArea(subjectArea);
        return subjectArea;
    }

    @PostMapping("/subjectarea/update/{id}")
    public void updateSubjectArea(@RequestBody SubjectArea subjectArea, @PathVariable Long id) {
        subjectAreaService.updateSubjectArea(subjectArea, id);
    }

    @PostMapping("/subjectarea/update/")
    public SubjectArea updateSubjectArea() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/subjectarea/delete/{id}")
    public String deleteSubjectArea(@PathVariable Long id) {
        subjectAreaService.deleteSubjectArea(id);
        return "SubjectArea with ID = " + id + " was deleted";
    }

    @PostMapping("/subjectarea/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
