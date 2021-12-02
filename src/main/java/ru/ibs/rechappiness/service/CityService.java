package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Customer;

import java.util.List;

public interface CityService {
    City getCity(Long id);

    void saveCity(City city);

    void deleteCity(Long id);

    List<City> getAllCities();

    void updateCity(City city, Long id);
}
