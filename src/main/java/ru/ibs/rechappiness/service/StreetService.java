package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Street;

import java.util.List;

public interface StreetService {
    Street getStreet(Long id);

    void saveStreet(Street street);

    void deleteStreet(Long id);

    List<Street> getAllStreets();

    void updateStreet(Street street, Long id);
}
