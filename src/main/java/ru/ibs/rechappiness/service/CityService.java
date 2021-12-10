package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto getCity(Long id);

    void saveCity(CityDto city);

    void deleteCity(Long id);

    List<CityDto> getAllCities();

    void updateCity(CityDto cityDto, Long id);
}
