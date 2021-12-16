package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.TechnologyDto;
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
    public TechnologyDto getTechnology(@PathVariable Long id) {
        return technologyService.getTechnology(id);
    }

    @PostMapping("/technology/create")
    public void addNewTechnology(@RequestBody TechnologyDto technologyDto) {
        technologyService.saveTechnology(technologyDto);
    }

    @PostMapping("/technology/update/{id}")
    public void updateTechnology(@RequestBody TechnologyDto technologyDto, @PathVariable Long id) {
        technologyService.updateTechnology(technologyDto, id);
    }

    @PostMapping("/technology/delete/{id}")
    public String deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return "Technology with ID = " + id + " was deleted";
    }
}
