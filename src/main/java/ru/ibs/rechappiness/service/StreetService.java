package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.StreetDto;

import java.util.List;

public interface StreetService {
    StreetDto getStreet(Long id);

    void saveStreet(StreetDto streetDto);

    void deleteStreet(Long id);

    List<StreetDto> getAllStreets();

    void updateStreet(StreetDto streetDto, Long id);
}
