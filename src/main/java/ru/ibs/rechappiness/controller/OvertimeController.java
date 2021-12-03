package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Overtime;
import ru.ibs.rechappiness.service.OvertimeService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class OvertimeController {

    private final OvertimeService overtimeService;

    public OvertimeController(OvertimeService overtimeService) {
        this.overtimeService = overtimeService;
    }

    @GetMapping("/overtime/read")
    public List<Overtime> showAllOvertimes() {
        return overtimeService.getAllOvertimes();
    }

    @GetMapping("/overtime/read/{id}")
    public Overtime getOvertime(@PathVariable Long id) {
        return overtimeService.getOvertime(id);
    }

    @PostMapping("/overtime/create")
    public Overtime addNewOvertime(@RequestBody Overtime overtime) {
        overtimeService.saveOvertime(overtime);
        return overtime;
    }

    @PostMapping("/overtime/update/{id}")
    public void updateOvertime(@RequestBody Overtime overtime, @PathVariable Long id) {
        overtimeService.updateOvertime(overtime, id);
    }

    @PostMapping("/overtime/update/")
    public Overtime updateOvertime() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/overtime/delete/{id}")
    public String deleteOvertime(@PathVariable Long id) {
        overtimeService.deleteOvertime(id);
        return "overtime with ID = " + id + " was deleted";
    }

    @PostMapping("/overtime/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }

}
