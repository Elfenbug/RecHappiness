package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.CountryDto;
import ru.ibs.rechappiness.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/read")
    public List<CountryDto> showAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/country/read/{id}")
    public CountryDto getCountry(@PathVariable Long id) {
        return countryService.getCountry(id);
    }

    @PostMapping("/country/create")
    public void addNewCountry(@RequestBody CountryDto countryDto) {
        countryService.saveCountry(countryDto);
    }

    @PostMapping("/country/update/{id}")
    public void updateCountry(@RequestBody CountryDto countryDto, @PathVariable Long id) {
        countryService.updateCountry(countryDto, id);
    }

    @PostMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "country with ID = " + id + " was deleted";
    }
}
