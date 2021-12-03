package ru.ibs.rechappiness.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
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
    public List<FunctionalDirection> showAllFunctionalDirections() {
        return functionalDirectionService.getAllFunctionalDirections();
    }

    @GetMapping("/functionaldirection/read/{id}")
    public FunctionalDirection getFunctionalDirection(@PathVariable Long id) {
        return functionalDirectionService.getFunctionalDirection(id);
    }

    @PostMapping("/functionaldirection/create")
    public FunctionalDirection addNewFunctionalDirection(@RequestBody FunctionalDirection functionalDirection) {
        functionalDirectionService.saveFunctionalDirection(functionalDirection);
        return functionalDirection;
    }

    @PostMapping("/functionaldirection/update/{id}")
    public void updateFunctionalDirection(@RequestBody FunctionalDirection functionalDirection, @PathVariable Long id) {
        functionalDirectionService.updateFunctionalDirection(functionalDirection, id);
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
