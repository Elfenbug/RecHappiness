package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.repository.CountryRepository;
import ru.ibs.rechappiness.service.CountryService;

import java.util.List;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        log.info("IN CountryServiceImpl getAllCountries");
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(Long id) {
        log.info("IN CountryServiceImpl getCountry {}", id);
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCountry(Country country) {
        log.info("IN CountryServiceImpl saveCountry {}", country);
        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        log.info("IN CountryServiceImpl deleteCountry {}", id);
        countryRepository.deleteById(id);
    }

    @Override
    public void updateCountry(Country country, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", country);
        if (countryRepository.findById(id).orElse(null) != null) {
            country.setId(id);
            countryRepository.save(country);
        }
    }
}
