package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.KindDevelopDto;
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
    public List<KindDevelopDto> showAllKindDevelops() {
        return kindDevelopService.getAllKindDevelops();
    }

    @GetMapping("/kinddevelop/read/{id}")
    public KindDevelopDto getKindDevelop(@PathVariable Long id) {
        return kindDevelopService.getKindDevelop(id);
    }

    @PostMapping("/kinddevelop/create")
    public void addNewKindDevelop(@RequestBody KindDevelopDto kindDevelopDto) {
        kindDevelopService.saveKindDevelop(kindDevelopDto);
    }

    @PostMapping("/kinddevelop/update/{id}")
    public void updateKindDevelop(@RequestBody KindDevelopDto kindDevelopDto, @PathVariable Long id) {
        kindDevelopService.updateKindDevelop(kindDevelopDto, id);
    }

    @PostMapping("/kinddevelop/delete/{id}")
    public String deleteKindDevelop(@PathVariable Long id) {
        kindDevelopService.deleteKindDevelop(id);
        return "kindDevelop with ID = " + id + " was deleted";
    }
}
