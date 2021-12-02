package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.KindDevelop;

import java.util.List;

public interface KindDevelopService {

    KindDevelop getKindDevelop(Long id);

    void saveKindDevelop(KindDevelop kindDevelop);

    void deleteKindDevelop(Long id);

    List<KindDevelop> getAllKindDevelops();

    void updateKindDevelop(KindDevelop kindDevelop, Long id);
}
