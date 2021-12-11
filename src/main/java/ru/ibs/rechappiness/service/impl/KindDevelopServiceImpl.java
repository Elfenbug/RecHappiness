package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.KindDevelopDto;
import ru.ibs.rechappiness.mapper.KindDevelopMapper;
import ru.ibs.rechappiness.model.KindDevelop;
import ru.ibs.rechappiness.repository.KindDevelopRepository;
import ru.ibs.rechappiness.service.KindDevelopService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class KindDevelopServiceImpl implements KindDevelopService {

    private final KindDevelopRepository kindDevelopRepository;

    public KindDevelopServiceImpl(KindDevelopRepository kindDevelopRepository) {
        this.kindDevelopRepository = kindDevelopRepository;
    }

    @Override
    public List<KindDevelopDto> getAllKindDevelops() {
        log.info("IN KindDeveloperServiceImpl getAllKindDevelops");
        List<KindDevelopDto> kindDevelopDtoList = new ArrayList<>();
        List<KindDevelop> streetList = kindDevelopRepository.findAll();
        for (KindDevelop kindDevelops : streetList) {
            kindDevelopDtoList.add(KindDevelopMapper.INSTANCE.fromKindDevelop(kindDevelops));
        }
        return kindDevelopDtoList;
    }

    @Override
    public KindDevelopDto getKindDevelop(Long id) {
        log.info("IN KindDeveloperServiceImpl getKindDevelop {}", id);
        return KindDevelopMapper.INSTANCE.fromKindDevelop(kindDevelopRepository.findById(id).orElse(null));
    }

    @Override
    public void saveKindDevelop(KindDevelopDto kindDevelopDto) {
        log.info("IN KindDeveloperServiceImpl saveKindDevelop {}", kindDevelopDto);
        kindDevelopRepository.save(KindDevelopMapper.INSTANCE.toKindDevelop(kindDevelopDto));
    }

    @Override
    public void deleteKindDevelop(Long id) {
        log.info("IN KindDeveloperServiceImpl deleteKindDevelop {}", id);
        kindDevelopRepository.deleteById(id);
    }

    @Override
    public void updateKindDevelop(KindDevelopDto kindDevelopDto, Long id) {
        log.info("IN KindDeveloperServiceImpl updateKindDevelop {}", kindDevelopDto);
        if (kindDevelopRepository.findById(id).orElse(null) != null) {
            kindDevelopDto.setId(id);
            kindDevelopRepository.save(KindDevelopMapper.INSTANCE.toKindDevelop(kindDevelopDto));
        }
    }
}
