package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MethodologyDto {
    private Long id;
    private String name;
}
