package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.LocationDto;

import java.util.List;

public interface LocationService {
    LocationDto getLocation(Long id);

    void saveLocation(LocationDto locationDto);

    void deleteLocation(Long id);

    List<LocationDto> getAllLocations();

    void updateLocation(LocationDto locationDto, Long id);
}
