package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Technology;

import java.util.List;

public interface TechnologyService {

    Technology getTechnology(Long id);

    void saveTechnology(Technology technology);

    void deleteTechnology(Long id);

    List<Technology> getAllTechnologies();

    void updateTechnology(Technology technology, Long id);
}
