package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Methodology;
import ru.ibs.rechappiness.repository.MethodologyRepository;
import ru.ibs.rechappiness.service.MethodologyService;

import java.util.List;

@Service
@Slf4j
public class MethodologyServiceImpl implements MethodologyService {

    private final MethodologyRepository methodologyRepository;

    public MethodologyServiceImpl(MethodologyRepository methodologyRepository) {
        this.methodologyRepository = methodologyRepository;
    }

    @Override
    public List<Methodology> getAllMethodologies() {
        log.info("IN MethodologyServiceImpl getAllMethodologies");
        return methodologyRepository.findAll();
    }

    @Override
    public Methodology getMethodology(Long id) {
        log.info("IN MethodologyServiceImpl getMethodology {}", id);
        return methodologyRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMethodology(Methodology methodology) {
        log.info("IN MethodologyServiceImpl saveMethodology {}", methodology);
        methodologyRepository.save(methodology);
    }

    @Override
    public void deleteMethodology(Long id) {
        log.info("IN MethodologyServiceImpl deleteMethodology {}", id);
        methodologyRepository.deleteById(id);
    }

    @Override
    public void updateMethodology(Methodology methodology, Long id) {
        log.info("IN MethodologyServiceImpl updateMethodology {}", methodology);
        if (methodologyRepository.findById(id).orElse(null) != null) {
            methodology.setId(id);
            methodologyRepository.save(methodology);
        }
    }
}
