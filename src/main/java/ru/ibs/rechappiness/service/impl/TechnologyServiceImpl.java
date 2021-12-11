package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.TechnologyDto;
import ru.ibs.rechappiness.mapper.TechnologyMapper;
import ru.ibs.rechappiness.model.Technology;
import ru.ibs.rechappiness.repository.TechnologyRepository;
import ru.ibs.rechappiness.service.TechnologyService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<TechnologyDto> getAllTechnologies() {
        log.info("IN TechnologyServiceImpl getAllTechnologies");
        List<TechnologyDto> technologyDtoList = new ArrayList<>();
        List<Technology> technologyList = technologyRepository.findAll();
        for (Technology technologies : technologyList) {
            technologyDtoList.add(TechnologyMapper.INSTANCE.fromTechnology(technologies));
        }
        return technologyDtoList;
    }

    @Override
    public TechnologyDto getTechnology(Long id) {
        log.info("IN TechnologyServiceImpl getTechnology {}", id);
        return TechnologyMapper.INSTANCE.fromTechnology(technologyRepository.findById(id).orElse(null));
    }

    @Override
    public void saveTechnology(TechnologyDto technologyDto) {
        log.info("IN TechnologyServiceImpl saveTechnology {}", technologyDto);
        technologyRepository.save(TechnologyMapper.INSTANCE.toTechnology(technologyDto));
    }

    @Override
    public void deleteTechnology(Long id) {
        log.info("IN TechnologyServiceImpl deleteTechnology {}", id);
        technologyRepository.deleteById(id);
    }

    @Override
    public void updateTechnology(TechnologyDto technologyDto, Long id) {
        log.info("IN TechnologyServiceImpl updateTechnology {}", technologyDto);
        if (technologyRepository.findById(id).orElse(null) != null) {
            technologyDto.setId(id);
            technologyRepository.save(TechnologyMapper.INSTANCE.toTechnology(technologyDto));
        }
    }
}
