package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.model.Project;
import ru.ibs.rechappiness.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project/read")
    public List<Project> showAllProjects() {
        List<Project> allProjects = projectService.getAllProjects();
        return allProjects;
    }

//    @PostMapping("/project/add")
//    public
//
//    @GetMapping("")
//
//    @GetMapping("/project/{id}/edit")
//    public String projectEdit(@PathVariable(value = "id") long id, Model model) {
//
//    }


}
