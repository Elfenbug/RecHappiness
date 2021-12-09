package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.ibs.rechappiness.model.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto {
    private Long id;
    private String name;
    private Date deadline;
    private int stakeholder;
    private String description;
    private int countDeveloper;
    private int countAnalytic;
    private boolean tester;
    private boolean technicalWriter;
    private boolean checkReady;
    private Date teamDate;
    private boolean checkDocumentation;
//    private boolean gost;
    private String projectTask;

    private CustomerDto customer;
    private FunctionalDirectionDto functionalDirection;
    private SubjectAreaDto subjectArea;
    private ProjectStageDto projectStage;
    private ProjectTypeDto projectType;
    private MethodologyDto methodology;
    private KindDevelopDto kindDevelop;
    private Set<LocationDto> locations;
    private OvertimeDto overtime;
    private Set<TechnologyDto> technologies;

//    public void addLocation(LocationDto locationDto) {
//        if(locations == null) {
//            locations = new ArrayList<>();
//        }
//        locations.add(locationDto);
//    }
//
//    public void addTechnology(TechnologyDto technologyDto) {
//        if(technologies == null) {
//            technologies = new ArrayList<>();
//        }
//        technologies.add(technologyDto);
//    }
}
