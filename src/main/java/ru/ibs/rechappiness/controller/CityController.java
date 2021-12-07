package ru.ibs.rechappiness.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.CityDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.mapper.CityMapper;
import ru.ibs.rechappiness.mapper.LocationMapper;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/read")
    public List<CityDto> showAllCities() {
        return CityMapper.INSTANCE.map(cityService.getAllCities());
    }

    @GetMapping("/city/read/{id}")
    public CityDto getCity(@PathVariable Long id) {
        return CityMapper.INSTANCE.toDto(cityService.getCity(id));
    }

    @PostMapping("/city/create")
    public City addNewCity(@RequestBody City city) {
        cityService.saveCity(city);
        return city;
    }

    @PostMapping("/city/update/{id}")
    public void updateCity(@RequestBody City city, @PathVariable Long id) {
        cityService.updateCity(city, id);
    }

    @PostMapping("/city/update/")
    public City updateCity() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/city/delete/{id}")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "city with ID = " + id + " was deleted";
    }

    @PostMapping("/city/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }

}
