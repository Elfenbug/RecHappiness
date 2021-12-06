package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.ProjectType;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectTypeDto {
    private Long id;
    private String name;

    public ProjectType toDomain() {
        ProjectType projectType = new ProjectType();
        projectType.setId(id);
        projectType.setName(name);
        return projectType;
    }

    public static ProjectTypeDto toDto(ProjectType projectType) {
        ProjectTypeDto projectTypeDto = new ProjectTypeDto();
        projectTypeDto.setId(projectType.getId());
        projectTypeDto.setName(projectType.getName());
        return projectTypeDto;
    }
}
