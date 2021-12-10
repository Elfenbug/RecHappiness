package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
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
    public List<ProjectDto> showAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/project/read/{id}")
    public ProjectDto getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @PostMapping("/project/create")
    public void addNewProject(@RequestBody ProjectDto projectDto) {
        projectService.saveProject(projectDto);
    }

    @PostMapping("/project/update/{id}")
    public void updateProject(@RequestBody ProjectDto projectDto, @PathVariable Long id) {
        projectService.updateProject(projectDto, id);
    }

    @PostMapping("/project/update/")
    public Project updateProject() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Project with ID = " + id + " was deleted";
    }

    @PostMapping("/project/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
