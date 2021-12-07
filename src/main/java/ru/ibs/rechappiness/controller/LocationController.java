package ru.ibs.rechappiness.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.rechappiness.dto.LocationDto;
import ru.ibs.rechappiness.exception_handling.NoSuchElementException;
import ru.ibs.rechappiness.mapper.LocationMapper;
import ru.ibs.rechappiness.model.Location;
import ru.ibs.rechappiness.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/registers")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location/read")
    public List<LocationDto> showAllLocations() {
        return LocationMapper.INSTANCE.map(locationService.getAllLocations());
    }

    @GetMapping("/location/read/{id}")
    public LocationDto getLocation(@PathVariable Long id) {
        return LocationMapper.INSTANCE.toDto(locationService.getLocation(id));
    }

    @PostMapping("/location/create")
    public Location addNewLocation(@RequestBody Location location) {
        locationService.saveLocation(location);
        return location;
    }

    @PostMapping("/location/update/{id}")
    public void updateLocation(@RequestBody Location location, @PathVariable Long id) {
        locationService.updateLocation(location, id);
    }

    @PostMapping("/location/update/")
    public Location updateLocation() {
        throw new NoSuchElementException("Please use valid id");
    }

    @PostMapping("/location/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "location with ID = " + id + " was deleted";
    }

    @PostMapping("/location/delete")
    public String noIdToDelete() {
        throw new NoSuchElementException("Please, select ID to delete");
    }
}
