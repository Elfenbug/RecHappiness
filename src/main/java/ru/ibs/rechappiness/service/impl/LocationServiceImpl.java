package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Location;
import ru.ibs.rechappiness.repository.LocationRepository;
import ru.ibs.rechappiness.service.LocationService;

import java.util.List;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;


    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        log.info("IN LocationServiceImpl getAllLocations");
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(Long id) {
        log.info("IN LocationServiceImpl getLocation {}", id);
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public void saveLocation(Location location) {
        log.info("IN LocationServiceImpl saveLocation {}", location);
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long id) {
        log.info("IN LocationImpl deleteLocation {}", id);
        locationRepository.deleteById(id);
    }

    @Override
    public void updateLocation(Location location, Long id) {
        log.info("IN LocationServiceImpl updateLocation {}", location);
        if (locationRepository.findById(id).orElse(null) != null) {
            location.setId(id);
            locationRepository.save(location);
        }
    }
}
