package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.SubjectAreaDto;
import ru.ibs.rechappiness.mapper.SubjectAreaMapper;
import ru.ibs.rechappiness.model.SubjectArea;
import ru.ibs.rechappiness.repository.SubjectAreaRepository;
import ru.ibs.rechappiness.service.SubjectAreaService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SubjectAreaServiceImpl implements SubjectAreaService {

    private final SubjectAreaRepository subjectAreaRepository;

    public SubjectAreaServiceImpl(SubjectAreaRepository subjectAreaRepository) {
        this.subjectAreaRepository = subjectAreaRepository;
    }

    @Override
    public List<SubjectAreaDto> getAllSubjectAreas() {
        log.info("IN CustomerServiceImpl getAllCustomers");
        List<SubjectAreaDto> subjectAreaDtoList = new ArrayList<>();
        List<SubjectArea> subjectAreaList = subjectAreaRepository.findAll();
        for (SubjectArea subjectAreas : subjectAreaList) {
            subjectAreaDtoList.add(SubjectAreaMapper.INSTANCE.fromSubjectArea(subjectAreas));
        }
        return subjectAreaDtoList;
    }

    @Override
    public SubjectAreaDto getSubjectArea(Long id) {
        log.info("IN CustomerServiceImpl getCustomer {}", id);
        return SubjectAreaMapper.INSTANCE.fromSubjectArea(subjectAreaRepository.findById(id).orElse(null));
    }

    @Override
    public void saveSubjectArea(SubjectAreaDto subjectAreaDto) {
        log.info("IN CustomerServiceImpl saveCustomer {}", subjectAreaDto);
        subjectAreaRepository.save(SubjectAreaMapper.INSTANCE.toSubjectArea(subjectAreaDto));
    }

    @Override
    public void deleteSubjectArea(Long id) {
        log.info("IN CustomerServiceImpl deleteCustomer {}", id);
        subjectAreaRepository.deleteById(id);
    }

    @Override
    public void updateSubjectArea(SubjectAreaDto subjectAreaDto, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", subjectAreaDto);
        if (subjectAreaRepository.findById(id).orElse(null) != null) {
            subjectAreaDto.setId(id);
            subjectAreaRepository.save(SubjectAreaMapper.INSTANCE.toSubjectArea(subjectAreaDto));
        }
    }
}
