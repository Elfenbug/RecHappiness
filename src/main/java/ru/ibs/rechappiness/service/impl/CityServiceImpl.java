package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.CityDto;
import ru.ibs.rechappiness.mapper.CityMapper;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.repository.CityRepository;
import ru.ibs.rechappiness.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> getAllCities() {
        log.info("IN CityServiceImpl getAllCities");
        List<CityDto> cityDtoList = new ArrayList<>();
        List<City> cityList = cityRepository.findAll();
        for (City cities : cityList) {
            cityDtoList.add(CityMapper.INSTANCE.fromCity(cities));
        }
        return cityDtoList;
    }

    @Override
    public CityDto getCity(Long id) {
        log.info("IN CityServiceImpl getCity {}", id);
        return CityMapper.INSTANCE.fromCity(cityRepository.findById(id).orElse(null));
    }

    @Override
    public void saveCity(CityDto cityDto) {
        log.info("IN CityServiceImpl saveCity {}", cityDto);
        cityRepository.save(CityMapper.INSTANCE.toCity(cityDto));
    }

    @Override
    public void deleteCity(Long id) {
        log.info("IN CityServiceImpl deleteCity {}", id);
        cityRepository.deleteById(id);
    }

    @Override
    public void updateCity(CityDto cityDto, Long id) {
        log.info("IN CustomerServiceImpl updateCity {}", cityDto);
        if (cityRepository.findById(id).orElse(null) != null) {
            cityDto.setId(id);
            cityRepository.save(CityMapper.INSTANCE.toCity(cityDto));
        }
    }
}
