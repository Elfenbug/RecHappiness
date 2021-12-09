package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.Street;
import ru.ibs.rechappiness.repository.StreetRepository;
import ru.ibs.rechappiness.service.StreetService;

import java.util.List;

@Service
@Slf4j
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }


    @Override
    public List<Street> getAllStreets() {
        log.info("IN StreetServiceImpl getAllStreets");
        return streetRepository.findAll();
    }

    @Override
    public Street getStreet(Long id) {
        log.info("IN StreetServiceImpl getStreet {}", id);
        return streetRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStreet(Street street) {
        log.info("IN StreetServiceImpl saveStreet {}", street);
        streetRepository.save(street);
    }

    @Override
    public void deleteStreet(Long id) {
        log.info("IN StreetServiceImpl deleteStreet {}", id);
        streetRepository.deleteById(id);
    }

    @Override
    public void updateStreet(Street street, Long id) {
        log.info("IN StreetServiceImpl updateStreet {}", street);
        if (streetRepository.findById(id).orElse(null) != null) {
            street.setId(id);
            streetRepository.save(street);
        }
    }
}
