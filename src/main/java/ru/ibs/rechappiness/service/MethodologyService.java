package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Methodology;

import java.util.List;

public interface MethodologyService {

    Methodology getMethodology(Long id);

    void saveMethodology(Methodology methodology);

    void deleteMethodology(Long id);

    List<Methodology> getAllMethodologies();

    void updateMethodology(Methodology methodology, Long id);
}
