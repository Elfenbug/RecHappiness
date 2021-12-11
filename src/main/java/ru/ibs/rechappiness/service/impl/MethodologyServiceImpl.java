package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.MethodologyDto;
import ru.ibs.rechappiness.mapper.MethodologyMapper;
import ru.ibs.rechappiness.model.Methodology;
import ru.ibs.rechappiness.repository.MethodologyRepository;
import ru.ibs.rechappiness.service.MethodologyService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MethodologyServiceImpl implements MethodologyService {

    private final MethodologyRepository methodologyRepository;

    public MethodologyServiceImpl(MethodologyRepository methodologyRepository) {
        this.methodologyRepository = methodologyRepository;
    }

    @Override
    public List<MethodologyDto> getAllMethodologies() {
        log.info("IN MethodologyServiceImpl getAllMethodologies");
        List<MethodologyDto> methodologyDtoList = new ArrayList<>();
        List<Methodology> methodologyList = methodologyRepository.findAll();
        for (Methodology methodologies : methodologyList) {
            methodologyDtoList.add(MethodologyMapper.INSTANCE.fromMethodology(methodologies));
        }
        return methodologyDtoList;
    }

    @Override
    public MethodologyDto getMethodology(Long id) {
        log.info("IN MethodologyServiceImpl getMethodology {}", id);
        return MethodologyMapper.INSTANCE.fromMethodology(methodologyRepository.findById(id).orElse(null));
    }

    @Override
    public void saveMethodology(MethodologyDto methodologyDto) {
        log.info("IN MethodologyServiceImpl saveMethodology {}", methodologyDto);
        methodologyRepository.save(MethodologyMapper.INSTANCE.toMethodology(methodologyDto));
    }

    @Override
    public void deleteMethodology(Long id) {
        log.info("IN MethodologyServiceImpl deleteMethodology {}", id);
        methodologyRepository.deleteById(id);
    }

    @Override
    public void updateMethodology(MethodologyDto methodologyDto, Long id) {
        log.info("IN MethodologyServiceImpl updateMethodology {}", methodologyDto);
        if (methodologyRepository.findById(id).orElse(null) != null) {
            methodologyDto.setId(id);
            methodologyRepository.save(MethodologyMapper.INSTANCE.toMethodology(methodologyDto));
        }
    }
}
