package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.StreetDto;
import ru.ibs.rechappiness.mapper.StreetMapper;
import ru.ibs.rechappiness.model.Street;
import ru.ibs.rechappiness.repository.StreetRepository;
import ru.ibs.rechappiness.service.StreetService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public List<StreetDto> getAllStreets() {
        log.info("IN StreetServiceImpl getAllStreets");
        List<StreetDto> streetDtoList = new ArrayList<>();
        List<Street> streetList = streetRepository.findAll();
        for (Street streets : streetList) {
            streetDtoList.add(StreetMapper.INSTANCE.fromStreet(streets));
        }
        return streetDtoList;
    }

    @Override
    public StreetDto getStreet(Long id) {
        log.info("IN StreetServiceImpl getStreet {}", id);
        return StreetMapper.INSTANCE.fromStreet(streetRepository.findById(id).orElse(null));
    }

    @Override
    public void saveStreet(StreetDto streetDto) {
        log.info("IN StreetServiceImpl saveStreet {}", streetDto);
        streetRepository.save(StreetMapper.INSTANCE.toStreet(streetDto));
    }

    @Override
    public void deleteStreet(Long id) {
        log.info("IN StreetServiceImpl deleteStreet {}", id);
        streetRepository.deleteById(id);
    }

    @Override
    public void updateStreet(StreetDto streetDto, Long id) {
        log.info("IN StreetServiceImpl updateStreet {}", streetDto);
        if (streetRepository.findById(id).orElse(null) != null) {
            streetDto.setId(id);
            streetRepository.save(StreetMapper.INSTANCE.toStreet(streetDto));
        }
    }
}
