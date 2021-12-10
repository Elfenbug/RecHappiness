package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.CountryDto;
import ru.ibs.rechappiness.mapper.CountryMapper;
import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.repository.CountryRepository;
import ru.ibs.rechappiness.service.CountryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        log.info("IN CountryServiceImpl getAllCountries");
        List<CountryDto> countryDtoList = new ArrayList<>();
        List<Country> countryList = countryRepository.findAll();
        for (Country countries : countryList) {
            countryDtoList.add(CountryMapper.INSTANCE.fromCountry(countries));
        }
        return countryDtoList;
    }

    @Override
    public CountryDto getCountry(Long id) {
        log.info("IN CountryServiceImpl getCountry {}", id);
        return CountryMapper.INSTANCE.fromCountry(countryRepository.findById(id).orElse(null));
    }

    @Override
    public void saveCountry(CountryDto countryDto) {
        log.info("IN CountryServiceImpl saveCountry {}", countryDto);
        countryRepository.save(CountryMapper.INSTANCE.toCountry(countryDto));
    }

    @Override
    public void deleteCountry(Long id) {
        log.info("IN CountryServiceImpl deleteCountry {}", id);
        countryRepository.deleteById(id);
    }

    @Override
    public void updateCountry(CountryDto countryDto, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", countryDto);
        if (countryRepository.findById(id).orElse(null) != null) {
            countryDto.setId(id);
            countryRepository.save(CountryMapper.INSTANCE.toCountry(countryDto));
        }
    }
}
