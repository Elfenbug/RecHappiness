package ru.ibs.rechappiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.model.Customer;
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
    public List<Country> showAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/country/read/{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getCountry(id);
    }

    @PostMapping("/country/create")
    public Country addNewCountry(@RequestBody Country country) {
        countryService.saveCountry(country);
        return country;
    }

    @PostMapping("/country/update/{id}")
    public void updateCountry(@RequestBody Country country, @PathVariable Long id) {
        countryService.updateCountry(country, id);
    }

    @PostMapping("/country/update/")
    public Customer updateCustomer() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "country with ID = " + id + " was deleted";
    }

    @PostMapping("/country/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
