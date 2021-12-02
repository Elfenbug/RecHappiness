package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.repository.CityRepository;
import ru.ibs.rechappiness.service.CityService;

import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        log.info("IN CityServiceImpl getAllCities");
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long id) {
        log.info("IN CityServiceImpl getCity {}", id);
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCity(City city) {
        log.info("IN CityServiceImpl saveCity {}", city);
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        log.info("IN CityServiceImpl deleteCity {}", id);
        cityRepository.deleteById(id);
    }

    @Override
    public void updateCity(City city, Long id) {
        log.info("IN CustomerServiceImpl updateCity {}", city);
        if (cityRepository.findById(id).orElse(null) != null) {
            city.setId(id);
            cityRepository.save(city);
        }
    }
}
