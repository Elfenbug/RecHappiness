package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.ProjectTypeDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.service.ProjectTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class ProjectTypeController {
    private final ProjectTypeService projectTypeService;

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping("/projecttype/read")
    public List<ProjectTypeDto> showAllProjectTypes() {
        return projectTypeService.getAllProjectTypes();
    }

    @GetMapping("/projecttype/read/{id}")
    public ProjectTypeDto getProjectType(@PathVariable Long id) {
        return projectTypeService.getProjectType(id);
    }

    @PostMapping("/projecttype/create")
    public void addNewProjectType(@RequestBody ProjectTypeDto projectTypeDto) {
        projectTypeService.saveProjectType(projectTypeDto);
    }

    @PostMapping("/projecttype/update/{id}")
    public void updateProjectType(@RequestBody ProjectTypeDto projectTypeDto, @PathVariable Long id) {
        projectTypeService.updateProjectType(projectTypeDto, id);
    }

    @PostMapping("/projecttype/update/")
    public Customer updateProjectType() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/projecttype/delete/{id}")
    public String deleteProjectType(@PathVariable Long id) {
        projectTypeService.deleteProjectType(id);
        return "ProjectType with ID = " + id + " was deleted";
    }

    @PostMapping("/projecttype/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
