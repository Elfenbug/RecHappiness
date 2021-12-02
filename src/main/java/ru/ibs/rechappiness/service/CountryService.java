package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.model.Customer;

import java.util.List;

public interface CountryService {

    Country getCountry(Long id);

    void saveCountry(Country country);

    void deleteCountry(Long id);

    List<Country> getAllCountries();

    void updateCountry(Country country, Long id);
}
