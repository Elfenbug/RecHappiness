package ru.ibs.rechappiness.service;

import ru.ibs.rechappiness.dto.SubjectAreaDto;

import java.util.List;

public interface SubjectAreaService {
    SubjectAreaDto getSubjectArea(Long id);

    void saveSubjectArea(SubjectAreaDto subjectAreaDto);

    void deleteSubjectArea(Long id);

    List<SubjectAreaDto> getAllSubjectAreas();

    void updateSubjectArea(SubjectAreaDto subjectAreaDto, Long id);

}
