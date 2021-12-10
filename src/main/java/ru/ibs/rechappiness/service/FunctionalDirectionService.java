package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.FunctionalDirectionDto;

import java.util.List;

public interface FunctionalDirectionService {

    FunctionalDirectionDto getFunctionalDirection(Long id);

    void saveFunctionalDirection(FunctionalDirectionDto functionalDirectionDto);

    void deleteFunctionalDirection(Long id);

    List<FunctionalDirectionDto> getAllFunctionalDirections();

    void updateFunctionalDirection(FunctionalDirectionDto functionalDirectionDto, Long id);
}
