package ru.ibs.rechappiness.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.ibs.rechappiness.dto.ProjectDto;
import ru.ibs.rechappiness.model.Project;

@Mapper(uses = {LocationMapper.class, TechnologyMapper.class})
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mappings({
            @Mapping(target = "deadline", source = "deadline",
                    dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "teamDate", source = "teamDate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")})
    Project toProject(ProjectDto projectDto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "technologies", ignore = true),
            @Mapping(target = "deadline", source = "deadline",
                    dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "teamDate", source = "teamDate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")})
    ProjectDto fromProject(Project project);
}
