package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Interviewer;
import ru.ibs.rechappiness.model.Project;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantDto {
    private Long id;
    private int countInterview;
    private Project project;
    private Interviewer interviewer;
}
