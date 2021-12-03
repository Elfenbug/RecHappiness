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

    @GetMapping("/kinddevelop/read")
    public List<KindDevelop> showAllKindDevelops() {
        return kindDevelopService.getAllKindDevelops();
    }

    @GetMapping("/kinddevelop/read/{id}")
    public KindDevelop getKindDevelop(@PathVariable Long id) {
        return kindDevelopService.getKindDevelop(id);
    }

    @PostMapping("/kinddevelop/create")
    public KindDevelop addNewKindDevelop(@RequestBody KindDevelop kindDevelop) {
        kindDevelopService.saveKindDevelop(kindDevelop);
        return kindDevelop;
    }

    @PostMapping("/kinddevelop/update/{id}")
    public void updateKindDevelop(@RequestBody KindDevelop kindDevelop, @PathVariable Long id) {
        kindDevelopService.updateKindDevelop(kindDevelop, id);
    }

    @PostMapping("/kinddevelop/update/")
    public Customer updateKindDevelop() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/kinddevelop/delete/{id}")
    public String deleteKindDevelop(@PathVariable Long id) {
        kindDevelopService.deleteKindDevelop(id);
        return "kindDevelop with ID = " + id + " was deleted";
    }

    @PostMapping("/kinddevelop/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
