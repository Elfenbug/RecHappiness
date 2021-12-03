package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Methodology;
import ru.ibs.rechappiness.service.MethodologyService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class MethodologyController {

    private final MethodologyService methodologyService;

    public MethodologyController(MethodologyService methodologyService) {
        this.methodologyService = methodologyService;
    }

    @GetMapping("/methodology/read")
    public List<Methodology> showAllMethodologies() {
        return methodologyService.getAllMethodologies();
    }

    @GetMapping("/methodology/read/{id}")
    public Methodology getMethodology(@PathVariable Long id) {
        return methodologyService.getMethodology(id);
    }

    @PostMapping("/methodology/create")
    public Methodology addNewMethodology(@RequestBody Methodology methodology) {
        methodologyService.saveMethodology(methodology);
        return methodology;
    }

    @PostMapping("/methodology/update/{id}")
    public void updateMethodology(@RequestBody Methodology methodology, @PathVariable Long id) {
        methodologyService.updateMethodology(methodology, id);
    }

    @PostMapping("/methodology/update/")
    public Methodology updateMethodology() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/methodology/delete/{id}")
    public String deleteMethodology(@PathVariable Long id) {
        methodologyService.deleteMethodology(id);
        return "methodology with ID = " + id + " was deleted";
    }

    @PostMapping("/methodology/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }

}
