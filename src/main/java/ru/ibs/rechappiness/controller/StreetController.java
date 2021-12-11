package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Street;
import ru.ibs.rechappiness.service.StreetService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class StreetController {
    private final StreetService streetService;

    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("/street/read")
    public List<StreetDto> showAllStreets() {
        return streetService.getAllStreets();
    }

    @GetMapping("/street/read/{id}")
    public StreetDto getById(@PathVariable Long id) {
        return streetService.getStreet(id);
    }

    @PostMapping("/street/create")
    public void addNewStreet(@RequestBody StreetDto streetDto) {
        streetService.saveStreet(streetDto);
    }

    @PostMapping("/street/update/{id}")
    public void updateStreet(@RequestBody StreetDto streetDto, @PathVariable Long id) {
        streetService.updateStreet(streetDto, id);
    }

    @PostMapping("/street/update/")
    public Street updateStreet() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/street/delete/{id}")
    public String deleteStreet(@PathVariable Long id) {
        streetService.deleteStreet(id);
        return "Street with ID = " + id + " was deleted";
    }

    @PostMapping("/street/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
