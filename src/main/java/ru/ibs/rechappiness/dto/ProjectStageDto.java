package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.ProjectStage;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectStageDto {
    private Long id;
    private String name;

    public ProjectStage toDomain() {
        ProjectStage projectStage = new ProjectStage();
        projectStage.setId(id);
        projectStage.setName(name);
        return projectStage;
    }

    public static ProjectStageDto toDto(City city) {
        ProjectStageDto projectStageDto = new ProjectStageDto();
        projectStageDto.setId(city.getId());
        projectStageDto.setName(city.getName());
        return projectStageDto;
    }
}
