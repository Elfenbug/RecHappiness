package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.ProjectType;
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
    public List<ProjectType> showAllProjectTypes() {
        return projectTypeService.getAllProjectTypes();
    }

    @GetMapping("/projecttype/read/{id}")
    public ProjectType getProjectType(@PathVariable Long id) {
        return projectTypeService.getProjectType(id);
    }

    @PostMapping("/projecttype/create")
    public ProjectType addNewProjectType(@RequestBody ProjectType projectType) {
        projectTypeService.saveProjectType(projectType);
        return projectType;
    }

    @PostMapping("/projecttype/update/{id}")
    public void updateProjectType(@RequestBody ProjectType projectType, @PathVariable Long id) {
        projectTypeService.updateProjectType(projectType, id);
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
