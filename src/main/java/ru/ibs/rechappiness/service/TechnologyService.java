package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    TechnologyDto getTechnology(Long id);

    void saveTechnology(TechnologyDto technologyDto);

    void deleteTechnology(Long id);

    List<TechnologyDto> getAllTechnologies();

    void updateTechnology(TechnologyDto technologyDto, Long id);
}
