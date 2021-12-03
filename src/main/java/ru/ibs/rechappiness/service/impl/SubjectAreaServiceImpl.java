package ru.ibs.rechappiness.service.impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.SubjectArea;
import ru.ibs.rechappiness.repository.SubjectAreaRepository;
import ru.ibs.rechappiness.service.SubjectAreaService;

import java.util.List;

@Service
@Slf4j
public class SubjectAreaServiceImpl implements SubjectAreaService {

    private final SubjectAreaRepository subjectAreaRepository;

    public SubjectAreaServiceImpl(SubjectAreaRepository subjectAreaRepository) {
        this.subjectAreaRepository = subjectAreaRepository;
    }

    @Override
    public List<SubjectArea> getAllSubjectAreas() {
        log.info("IN CustomerServiceImpl getAllCustomers");
        return subjectAreaRepository.findAll();
    }

    @Override
    public SubjectArea getSubjectArea(Long id) {
        log.info("IN CustomerServiceImpl getCustomer {}", id);
        return subjectAreaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSubjectArea(SubjectArea subjectArea) {
        log.info("IN CustomerServiceImpl saveCustomer {}", subjectArea);
        subjectAreaRepository.save(subjectArea);
    }

    @Override
    public void deleteSubjectArea(Long id) {
        log.info("IN CustomerServiceImpl deleteCustomer {}", id);
        subjectAreaRepository.deleteById(id);
    }

    @Override
    public void updateSubjectArea(SubjectArea subjectArea, Long id) {
        log.info("IN CustomerServiceImpl updateCustomer {}", subjectArea);
        if (subjectAreaRepository.findById(id).orElse(null) != null) {
            subjectArea.setId(id);
            subjectAreaRepository.save(subjectArea);
        }
    }
}
