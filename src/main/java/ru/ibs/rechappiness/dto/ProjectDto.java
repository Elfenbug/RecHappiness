package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto {
    private Long id;
    private String name;
    private String deadline;
    //private Date deadline;
    private int stakeholder;
    private String description;
    private int countDeveloper;
    private int countAnalytic;
    private boolean tester;
    private boolean technicalWriter;
    private boolean checkReady;
    private String teamDate;
    private boolean checkDocumentation;
//    private boolean gost;
    private String projectTask;

//    private CustomerDto customer;
    private FunctionalDirectionDto functionalDirection;
    private SubjectAreaDto subjectArea;
    private ProjectStageDto projectStage;
    private ProjectTypeDto projectType;
    private MethodologyDto methodology;
    private KindDevelopDto kindDevelop;
    private Set<LocationDto> locations;
    private OvertimeDto overtime;
    private Set<TechnologyDto> technologies;
}
