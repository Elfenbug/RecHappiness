package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.FunctionalDirectionDto;
import ru.ibs.rechappiness.mapper.FunctionalDirectionMapper;
import ru.ibs.rechappiness.model.FunctionalDirection;
import ru.ibs.rechappiness.repository.FunctionalDirectionRepository;
import ru.ibs.rechappiness.service.FunctionalDirectionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FunctionalDirectionServiceImpl implements FunctionalDirectionService {

    private final FunctionalDirectionRepository functionalDirectionRepository;

    public FunctionalDirectionServiceImpl(FunctionalDirectionRepository functionalDirectionRepository) {
        this.functionalDirectionRepository = functionalDirectionRepository;
    }

    @Override
    public List<FunctionalDirectionDto> getAllFunctionalDirections() {
        log.info("IN FunctionalDirectionServiceImpl getAllFunctionalDirections");
        List<FunctionalDirectionDto> functionalDirectionDtoList = new ArrayList<>();
        List<FunctionalDirection> functionalDirectionList = functionalDirectionRepository.findAll();
        for (FunctionalDirection functionalDirections : functionalDirectionList) {
            functionalDirectionDtoList.add(FunctionalDirectionMapper.INSTANCE.fromFunctionalDirection(functionalDirections));
        }
        return functionalDirectionDtoList;
    }

    @Override
    public FunctionalDirectionDto getFunctionalDirection(Long id) {
        log.info("IN FunctionalDirectionServiceImpl getFunctionalDirection {}", id);
        return FunctionalDirectionMapper.INSTANCE.fromFunctionalDirection(functionalDirectionRepository.findById(id).orElse(null));
    }

    @Override
    public void saveFunctionalDirection(FunctionalDirectionDto functionalDirectionDto) {
        log.info("IN FunctionalDirectionServiceImpl saveFunctionalDirection {}", functionalDirectionDto);
        functionalDirectionRepository.save(FunctionalDirectionMapper.INSTANCE.toFunctionalDirection(functionalDirectionDto));
    }

    @Override
    public void deleteFunctionalDirection(Long id) {
        log.info("IN FunctionalDirectionServiceImpl deleteFunctionalDirection {}", id);
        functionalDirectionRepository.deleteById(id);
    }

    @Override
    public void updateFunctionalDirection(FunctionalDirectionDto functionalDirectionDto, Long id) {
        log.info("IN FunctionalDirectionServiceImpl updateFunctionalDirection {}", functionalDirectionDto);
        if (functionalDirectionRepository.findById(id).orElse(null) != null) {
            functionalDirectionDto.setId(id);
            functionalDirectionRepository.save(FunctionalDirectionMapper.INSTANCE.toFunctionalDirection(functionalDirectionDto));
        }
    }
}
