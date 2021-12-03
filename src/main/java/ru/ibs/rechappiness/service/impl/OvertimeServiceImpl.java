package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.model.Overtime;
import ru.ibs.rechappiness.repository.OvertimeRepository;
import ru.ibs.rechappiness.service.OvertimeService;

import java.util.List;

@Service
@Slf4j
public class OvertimeServiceImpl implements OvertimeService {

    private final OvertimeRepository overtimeRepository;

    public OvertimeServiceImpl(OvertimeRepository overtimeRepository) {
        this.overtimeRepository = overtimeRepository;
    }

    @Override
    public List<Overtime> getAllOvertimes() {
        log.info("IN OvertimeServiceImpl getAllOvertimes");
        return overtimeRepository.findAll();
    }

    @Override
    public Overtime getOvertime(Long id) {
        log.info("IN OvertimeServiceImpl getOvertime {}", id);
        return overtimeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOvertime(Overtime overtime) {
        log.info("IN OvertimeServiceImpl saveOvertime {}", overtime);
        overtimeRepository.save(overtime);
    }

    @Override
    public void deleteOvertime(Long id) {
        log.info("IN OvertimeServiceImpl deleteOvertime {}", id);
        overtimeRepository.deleteById(id);
    }

    @Override
    public void updateOvertime(Overtime overtime, Long id) {
        log.info("IN OvertimeServiceImpl updateOvertime {}", overtime);
        if (overtimeRepository.findById(id).orElse(null) != null) {
            overtime.setId(id);
            overtimeRepository.save(overtime);
        }
    }
}
