package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.CountryDto;
import ru.ibs.rechappiness.model.Country;

import java.util.List;

public interface CountryService {

    CountryDto getCountry(Long id);

    void saveCountry(CountryDto countryDto);

    void deleteCountry(Long id);

    List<CountryDto> getAllCountries();

    void updateCountry(CountryDto countryDto, Long id);
}
