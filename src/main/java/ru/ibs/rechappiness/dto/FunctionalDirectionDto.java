package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.FunctionalDirection;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionalDirectionDto {
    private Long id;
    private String name;

    public FunctionalDirection toDomain() {
        FunctionalDirection functionalDirection = new FunctionalDirection();
        functionalDirection.setId(id);
        functionalDirection.setName(name);
        return functionalDirection;
    }

    public static FunctionalDirectionDto toDto(FunctionalDirection functionalDirection) {
        FunctionalDirectionDto functionalDirectionDto = new FunctionalDirectionDto();
        functionalDirectionDto.setId(functionalDirection.getId());
        functionalDirectionDto.setName(functionalDirection.getName());
        return functionalDirectionDto;
    }
}
