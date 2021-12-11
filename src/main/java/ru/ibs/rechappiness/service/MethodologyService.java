package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.MethodologyDto;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Methodology;

import java.util.List;

public interface MethodologyService {

    MethodologyDto getMethodology(Long id);

    void saveMethodology(MethodologyDto methodologyDto);

    void deleteMethodology(Long id);

    List<MethodologyDto> getAllMethodologies();

    void updateMethodology(MethodologyDto methodologyDto, Long id);
}
