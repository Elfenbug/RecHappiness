package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.SubjectArea;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectAreaDto {
    private Long id;
    private String name;

    public SubjectArea toDomain() {
        SubjectArea subjectArea = new SubjectArea();
        subjectArea.setId(id);
        subjectArea.setName(name);
        return subjectArea;
    }

    public static SubjectAreaDto toDto(SubjectArea subjectArea) {
        SubjectAreaDto subjectAreaDto = new SubjectAreaDto();
        subjectAreaDto.setId(subjectArea.getId());
        subjectAreaDto.setName(subjectArea.getName());
        return subjectAreaDto;
    }
}
