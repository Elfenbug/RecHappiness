package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectStage;
import ru.ibs.rechappiness.service.ProjectService;
import ru.ibs.rechappiness.service.ProjectStageService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class ProjectStageController {

    private final ProjectStageService projectStageService;

    public ProjectStageController(ProjectStageService projectStageService) {
        this.projectStageService = projectStageService;
    }

    @GetMapping("/projectstage/read")
    public List<ProjectStage> showAllProjectStages() {
        return projectStageService.getAllProjectStages();
    }

    @GetMapping("/projectstage/read/{id}")
    public ProjectStage getProjectStage(@PathVariable Long id) {
        return projectStageService.getProjectStage(id);
    }

    @PostMapping("/projectstage/create")
    public ProjectStage addNewProjectStage(@RequestBody ProjectStage projectStage) {
        projectStageService.saveProjectStage(projectStage);
        return projectStage;
    }

    @PostMapping("/projectstage/update/{id}")
    public void updateProjectStage(@RequestBody ProjectStage projectStage, @PathVariable Long id) {
        projectStageService.updateProjectStage(projectStage, id);
    }

    @PostMapping("/projectstage/update/")
    public ProjectStage updateProjectStage() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/projectstage/delete/{id}")
    public String deleteProjectStage(@PathVariable Long id) {
        projectStageService.deleteProjectStage(id);
        return "ProjectStage with ID = " + id + " was deleted";
    }

    @PostMapping("/projectstage/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
