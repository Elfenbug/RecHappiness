package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.FunctionalDirection;

import java.util.List;

public interface FunctionalDirectionService {

    FunctionalDirection getFunctionalDirection(Long id);

    void saveFunctionalDirection(FunctionalDirection functionalDirection);

    void deleteFunctionalDirection(Long id);

    List<FunctionalDirection> getAllFunctionalDirections();

    void updateFunctionalDirection(FunctionalDirection functionalDirection, Long id);
}
