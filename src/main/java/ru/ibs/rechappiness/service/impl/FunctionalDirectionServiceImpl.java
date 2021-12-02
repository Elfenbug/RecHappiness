package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.FunctionalDirection;
import ru.ibs.rechappiness.repository.FunctionalDirectionRepository;
import ru.ibs.rechappiness.service.FunctionalDirectionService;

import java.util.List;

@Service
@Slf4j
public class FunctionalDirectionServiceImpl implements FunctionalDirectionService {

    private final FunctionalDirectionRepository functionalDirectionRepository;

    public FunctionalDirectionServiceImpl(FunctionalDirectionRepository functionalDirectionRepository) {
        this.functionalDirectionRepository = functionalDirectionRepository;
    }

    @Override
    public List<FunctionalDirection> getAllFunctionalDirections() {
        log.info("IN FunctionalDirectionServiceImpl getAllFunctionalDirections");
        return functionalDirectionRepository.findAll();
    }

    @Override
    public FunctionalDirection getFunctionalDirection(Long id) {
        log.info("IN FunctionalDirectionServiceImpl getFunctionalDirection {}", id);
        return functionalDirectionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveFunctionalDirection(FunctionalDirection functionalDirection) {
        log.info("IN FunctionalDirectionServiceImpl saveFunctionalDirection {}", functionalDirection);
        functionalDirectionRepository.save(functionalDirection);
    }

    @Override
    public void deleteFunctionalDirection(Long id) {
        log.info("IN FunctionalDirectionServiceImpl deleteFunctionalDirection {}", id);
        functionalDirectionRepository.deleteById(id);
    }

    @Override
    public void updateFunctionalDirection(FunctionalDirection functionalDirection, Long id) {
        log.info("IN FunctionalDirectionServiceImpl updateFunctionalDirection {}", functionalDirection);
        if (functionalDirectionRepository.findById(id).orElse(null) != null) {
            functionalDirection.setId(id);
            functionalDirectionRepository.save(functionalDirection);
        }
    }
}
