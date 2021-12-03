package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Technology;
import ru.ibs.rechappiness.repository.TechnologyRepository;
import ru.ibs.rechappiness.service.TechnologyService;

import java.util.List;

@Service
@Slf4j
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<Technology> getAllTechnologies() {
        log.info("IN TechnologyServiceImpl getAllTechnologies");
        return technologyRepository.findAll();
    }

    @Override
    public Technology getTechnology(Long id) {
        log.info("IN TechnologyServiceImpl getTechnology {}", id);
        return technologyRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTechnology(Technology technology) {
        log.info("IN TechnologyServiceImpl saveTechnology {}", technology);
        technologyRepository.save(technology);
    }

    @Override
    public void deleteTechnology(Long id) {
        log.info("IN TechnologyServiceImpl deleteTechnology {}", id);
        technologyRepository.deleteById(id);
    }

    @Override
    public void updateTechnology(Technology technology, Long id) {
        log.info("IN TechnologyServiceImpl updateTechnology {}", technology);
        if (technologyRepository.findById(id).orElse(null) != null) {
            technology.setId(id);
            technologyRepository.save(technology);
        }
    }
}
