package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Customer;
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

    @GetMapping("/streetservice/read")
    public List<Street> showAllStreets() {
        return streetService.getAllStreets();
    }

    @GetMapping("/streetservice/read/{id}")
//    public Street getStreet(@PathVariable Long id) {
//        return streetService.getStreet(id);
//    }
    public StreetDto getById(@PathVariable Long id) {
        return StreetDto.toDto(streetService.getStreet(id));
    }

    @PostMapping("/streetservice/create")
    public Street addNewStreet(@RequestBody Street street) {
        streetService.saveStreet(street);
        return street;
    }

    @PostMapping("/streetservice/update/{id}")
    public void updateStreet(@RequestBody Street street, @PathVariable Long id) {
        streetService.updateStreet(street, id);
    }

    @PostMapping("/streetservice/update/")
    public Street updateStreet() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/streetservice/delete/{id}")
    public String deleteStreet(@PathVariable Long id) {
        streetService.deleteStreet(id);
        return "Street with ID = " + id + " was deleted";
    }

    @PostMapping("/streetservice/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
