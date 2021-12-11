package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.KindDevelopDto;

import java.util.List;

public interface KindDevelopService {

    KindDevelopDto getKindDevelop(Long id);

    void saveKindDevelop(KindDevelopDto kindDevelopDto);

    void deleteKindDevelop(Long id);

    List<KindDevelopDto> getAllKindDevelops();

    void updateKindDevelop(KindDevelopDto kindDevelopDto, Long id);
}
