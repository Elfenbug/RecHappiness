package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.FunctionalDirectionDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.FunctionalDirection;
import ru.ibs.rechappiness.service.FunctionalDirectionService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class FunctionalDirectionController {

    private final FunctionalDirectionService functionalDirectionService;

    public FunctionalDirectionController(FunctionalDirectionService functionalDirectionService) {
        this.functionalDirectionService = functionalDirectionService;
    }

    @GetMapping("/functionaldirection/read")
    public List<FunctionalDirectionDto> showAllFunctionalDirections() {
        return functionalDirectionService.getAllFunctionalDirections();
    }

    @GetMapping("/functionaldirection/read/{id}")
    public FunctionalDirectionDto getFunctionalDirection(@PathVariable Long id) {
        return functionalDirectionService.getFunctionalDirection(id);
    }

    @PostMapping("/functionaldirection/create")
    public void addNewFunctionalDirection(@RequestBody FunctionalDirectionDto functionalDirectionDto) {
        functionalDirectionService.saveFunctionalDirection(functionalDirectionDto);
    }

    @PostMapping("/functionaldirection/update/{id}")
    public void updateFunctionalDirection(@RequestBody FunctionalDirectionDto functionalDirectionDto, @PathVariable Long id) {
        functionalDirectionService.updateFunctionalDirection(functionalDirectionDto, id);
    }

    @PostMapping("/functionaldirection/update/")
    public FunctionalDirection updateFunctionalDirection() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/functionaldirection/delete/{id}")
    public String deleteFunctionalDirection(@PathVariable Long id) {
        functionalDirectionService.deleteFunctionalDirection(id);
        return "functionaldirection with ID = " + id + " was deleted";
    }

    @PostMapping("/functionaldirection/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
