package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
}
