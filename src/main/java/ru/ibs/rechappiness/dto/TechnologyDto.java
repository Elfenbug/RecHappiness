package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Project;
import ru.ibs.rechappiness.model.Technology;

import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TechnologyDto {
    private Long id;
    private String name;

}
