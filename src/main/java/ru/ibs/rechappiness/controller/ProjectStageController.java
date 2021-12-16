package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.ProjectStageDto;
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
    public List<ProjectStageDto> showAllProjectStages() {
        return projectStageService.getAllProjectStages();
    }

    @GetMapping("/projectstage/read/{id}")
    public ProjectStageDto getProjectStage(@PathVariable Long id) {
        return projectStageService.getProjectStage(id);
    }

    @PostMapping("/projectstage/create")
    public void addNewProjectStage(@RequestBody ProjectStageDto projectStageDto) {
        projectStageService.saveProjectStage(projectStageDto);
    }

    @PostMapping("/projectstage/update/{id}")
    public void updateProjectStage(@RequestBody ProjectStageDto projectStageDto, @PathVariable Long id) {
        projectStageService.updateProjectStage(projectStageDto, id);
    }

    @PostMapping("/projectstage/delete/{id}")
    public String deleteProjectStage(@PathVariable Long id) {
        projectStageService.deleteProjectStage(id);
        return "ProjectStage with ID = " + id + " was deleted";
    }
}
