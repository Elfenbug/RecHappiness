package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.LocationDto;
import ru.ibs.rechappiness.mapper.LocationMapper;
import ru.ibs.rechappiness.model.Location;
import ru.ibs.rechappiness.repository.LocationRepository;
import ru.ibs.rechappiness.service.LocationService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        log.info("IN LocationServiceImpl getAllLocations");
        List<LocationDto> locationDtoList = new ArrayList<>();
        List<Location> locationList = locationRepository.findAll();
        for (Location locations : locationList) {
            locationDtoList.add(LocationMapper.INSTANCE.fromLocation(locations));
        }
        return locationDtoList;
    }

    @Override
    public LocationDto getLocation(Long id) {
        log.info("IN LocationServiceImpl getLocation {}", id);
        return LocationMapper.INSTANCE.fromLocation(locationRepository.findById(id).orElse(null));
    }

    @Override
    public void saveLocation(LocationDto locationDto) {
        log.info("IN LocationServiceImpl saveLocation {}", locationDto);
        locationRepository.save(LocationMapper.INSTANCE.toLocation(locationDto));
    }

    @Override
    public void deleteLocation(Long id) {
        log.info("IN LocationImpl deleteLocation {}", id);
        locationRepository.deleteById(id);
    }

    @Override
    public void updateLocation(LocationDto locationDto, Long id) {
        log.info("IN LocationServiceImpl updateLocation {}", locationDto);
        if (locationRepository.findById(id).orElse(null) != null) {
            locationDto.setId(id);
            locationRepository.save(LocationMapper.INSTANCE.toLocation(locationDto));
        }
    }
}
