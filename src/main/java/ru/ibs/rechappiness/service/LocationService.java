package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Location;

import java.util.List;

public interface LocationService {

    Location getLocation(Long id);

    void saveLocation(Location location);

    void deleteLocation(Long id);

    List<Location> getAllLocations();

    void updateLocation(Location location, Long id);
}
