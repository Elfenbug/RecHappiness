package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.KindDevelop;
import ru.ibs.rechappiness.repository.KindDevelopRepository;
import ru.ibs.rechappiness.service.KindDevelopService;

import java.util.List;

@Service
@Slf4j
public class KindDevelopServiceImpl implements KindDevelopService {

    private final KindDevelopRepository kindDevelopRepository;

    public KindDevelopServiceImpl(KindDevelopRepository kindDevelopRepository) {
        this.kindDevelopRepository = kindDevelopRepository;
    }

    @Override
    public List<KindDevelop> getAllKindDevelops() {
        log.info("IN KindDeveloperServiceImpl getAllKindDevelops");
        return kindDevelopRepository.findAll();
    }

    @Override
    public KindDevelop getKindDevelop(Long id) {
        log.info("IN KindDeveloperServiceImpl getKindDevelop {}", id);
        return kindDevelopRepository.findById(id).orElse(null);
    }

    @Override
    public void saveKindDevelop(KindDevelop kindDevelop) {
        log.info("IN KindDeveloperServiceImpl saveKindDevelop {}", kindDevelop);
        kindDevelopRepository.save(kindDevelop);
    }

    @Override
    public void deleteKindDevelop(Long id) {
        log.info("IN KindDeveloperServiceImpl deleteKindDevelop {}", id);
        kindDevelopRepository.deleteById(id);
    }

    @Override
    public void updateKindDevelop(KindDevelop kindDevelop, Long id) {
        log.info("IN KindDeveloperServiceImpl updateKindDevelop {}", kindDevelop);
        if (kindDevelopRepository.findById(id).orElse(null) != null) {
            kindDevelop.setId(id);
            kindDevelopRepository.save(kindDevelop);
        }
    }
}
