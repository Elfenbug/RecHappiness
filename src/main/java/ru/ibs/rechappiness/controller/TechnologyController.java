package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.TechnologyDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Technology;
import ru.ibs.rechappiness.service.TechnologyService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
    @GetMapping("/technology/read")
    public List<TechnologyDto> showAllTechnologies() {
        return technologyService.getAllTechnologies();
    }

    @GetMapping("/technology/read/{id}")
    public Technology getTechnology(@PathVariable Long id) {
        return technologyService.getTechnology(id);
    }

    @PostMapping("/technology/create")
    public Technology addNewTechnology(@RequestBody Technology technology) {
        technologyService.saveTechnology(technology);
        return technology;
    }

    @PostMapping("/technology/update/{id}")
    public void updateTechnology(@RequestBody Technology technology, @PathVariable Long id) {
        technologyService.updateTechnology(technology, id);
    }

    @PostMapping("/technology/update/")
    public Technology updateTechnology() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/technology/delete/{id}")
    public String deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return "Technology with ID = " + id + " was deleted";
    }

    @PostMapping("/technology/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }

}
