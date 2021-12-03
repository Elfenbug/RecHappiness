package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.model.Customer;
import ru.ibs.rechappiness.model.SubjectArea;

import java.util.List;

public interface SubjectAreaService {
    SubjectArea getSubjectArea(Long id);

    void saveSubjectArea(SubjectArea subjectArea);

    void deleteSubjectArea(Long id);

    List<SubjectArea> getAllSubjectAreas();

    void updateSubjectArea(SubjectArea subjectArea, Long id);

}
