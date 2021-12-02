package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.KindDevelop;
import ru.ibs.rechappiness.service.KindDevelopService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class KindDevelopController {

    private final KindDevelopService kindDevelopService;

    public KindDevelopController(KindDevelopService kindDevelopService) {
        this.kindDevelopService = kindDevelopService;
    }

    @GetMapping("/customer/read")
    public List<KindDevelop> showAllKindDevelops() {
        return kindDevelopService.getAllKindDevelops();
    }

    @GetMapping("/customer/read/{id}")
    public KindDevelop getKindDevelop(@PathVariable Long id) {
        return kindDevelopService.getKindDevelop(id);
    }

    @PostMapping("/customer/create")
    public KindDevelop addNewKindDevelop(@RequestBody KindDevelop kindDevelop) {
        kindDevelopService.saveKindDevelop(kindDevelop);
        return kindDevelop;
    }

    @PostMapping("/customer/update/{id}")
    public void updateKindDevelop(@RequestBody KindDevelop kindDevelop, @PathVariable Long id) {
        kindDevelopService.updateKindDevelop(kindDevelop, id);
    }

    @PostMapping("/customer/update/")
    public Customer updateKindDevelop() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/customer/delete/{id}")
    public String deleteKindDevelop(@PathVariable Long id) {
        kindDevelopService.deleteKindDevelop(id);
        return "kindDevelop with ID = " + id + " was deleted";
    }

    @PostMapping("/customer/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
