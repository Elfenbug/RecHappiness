package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Overtime;

import java.util.List;

public interface OvertimeService {

    Overtime getOvertime(Long id);

    void saveOvertime(Overtime overtime);

    void deleteOvertime(Long id);

    List<Overtime> getAllOvertimes();

    void updateOvertime(Overtime overtime, Long id);
}
