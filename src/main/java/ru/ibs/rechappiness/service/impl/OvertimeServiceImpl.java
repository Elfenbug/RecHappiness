package ru.ibs.rechappiness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ibs.rechappiness.dto.OvertimeDto;
import ru.ibs.rechappiness.mapper.OvertimeMapper;
import ru.ibs.rechappiness.model.Overtime;
import ru.ibs.rechappiness.repository.OvertimeRepository;
import ru.ibs.rechappiness.service.OvertimeService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OvertimeServiceImpl implements OvertimeService {

    private final OvertimeRepository overtimeRepository;

    public OvertimeServiceImpl(OvertimeRepository overtimeRepository) {
        this.overtimeRepository = overtimeRepository;
    }

    @Override
    public List<OvertimeDto> getAllOvertimes() {
        log.info("IN OvertimeServiceImpl getAllOvertimes");
        List<OvertimeDto> overtimeDtoList = new ArrayList<>();
        List<Overtime> overtimeList = overtimeRepository.findAll();
        for (Overtime overtimes : overtimeList) {
            overtimeDtoList.add(OvertimeMapper.INSTANCE.fromOvertime(overtimes));
        }
        return overtimeDtoList;
    }

    @Override
    public OvertimeDto getOvertime(Long id) {
        log.info("IN OvertimeServiceImpl getOvertime {}", id);
        return OvertimeMapper.INSTANCE.fromOvertime(overtimeRepository.findById(id).orElse(null));
    }

    @Override
    public void saveOvertime(OvertimeDto overtimeDto) {
        log.info("IN OvertimeServiceImpl saveOvertime {}", overtimeDto);
        overtimeRepository.save(OvertimeMapper.INSTANCE.toOvertime(overtimeDto));
    }

    @Override
    public void deleteOvertime(Long id) {
        log.info("IN OvertimeServiceImpl deleteOvertime {}", id);
        overtimeRepository.deleteById(id);
    }

    @Override
    public void updateOvertime(OvertimeDto overtimeDto, Long id) {
        log.info("IN OvertimeServiceImpl updateOvertime {}", overtimeDto);
        if (overtimeRepository.findById(id).orElse(null) != null) {
            overtimeDto.setId(id);
            overtimeRepository.save(OvertimeMapper.INSTANCE.toOvertime(overtimeDto));
        }
    }
}
