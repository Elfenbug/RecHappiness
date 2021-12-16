package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.SubjectAreaDto;
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
    public List<SubjectAreaDto> showAllSubjectAreas() {
        return subjectAreaService.getAllSubjectAreas();
    }

    @GetMapping("/subjectarea/read/{id}")
    public SubjectAreaDto getSubjectArea(@PathVariable Long id) {
        return subjectAreaService.getSubjectArea(id);
    }

    @PostMapping("/subjectarea/create")
    public void addNewSubjectArea(@RequestBody SubjectAreaDto subjectAreaDto) {
        subjectAreaService.saveSubjectArea(subjectAreaDto);
    }

    @PostMapping("/subjectarea/update/{id}")
    public void updateSubjectArea(@RequestBody SubjectAreaDto subjectAreaDto, @PathVariable Long id) {
        subjectAreaService.updateSubjectArea(subjectAreaDto, id);
    }

    @PostMapping("/subjectarea/delete/{id}")
    public String deleteSubjectArea(@PathVariable Long id) {
        subjectAreaService.deleteSubjectArea(id);
        return "SubjectArea with ID = " + id + " was deleted";
    }
}
