package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Interviewer;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterviewerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Interviewer toDomain() {
        Interviewer interviewer = new Interviewer();
        interviewer.setId(id);
        interviewer.setFirstName(firstName);
        interviewer.setLastName(lastName);
        interviewer.setEmail(email);
        return interviewer;
    }

    public static InterviewerDto toDto(Interviewer interviewer) {
        InterviewerDto interviewerDto = new InterviewerDto();
        interviewerDto.setId(interviewer.getId());
        interviewerDto.setFirstName(interviewer.getFirstName());
        interviewerDto.setLastName(interviewer.getLastName());
        interviewerDto.setEmail(interviewer.getEmail());
        return interviewerDto;
    }
}
