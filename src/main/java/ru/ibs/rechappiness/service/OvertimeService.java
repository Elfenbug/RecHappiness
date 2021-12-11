package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.OvertimeDto;

import java.util.List;

public interface OvertimeService {

    OvertimeDto getOvertime(Long id);

    void saveOvertime(OvertimeDto overtimeDto);

    void deleteOvertime(Long id);

    List<OvertimeDto> getAllOvertimes();

    void updateOvertime(OvertimeDto overtimeDto, Long id);
}
