package ru.ibs.rechappiness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private boolean gost;
    private String projectTask;
}
