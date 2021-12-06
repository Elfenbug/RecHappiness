package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.model.Methodology;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MethodologyDto {
    private Long id;
    private String name;

    public Methodology toDomain() {
        Methodology methodology = new Methodology();
        methodology.setId(id);
        methodology.setName(name);
        return methodology;
    }

    public static MethodologyDto toDto(Methodology methodology) {
        MethodologyDto methodologyDto = new MethodologyDto();
        methodologyDto.setId(methodology.getId());
        methodologyDto.setName(methodology.getName());
        return methodologyDto;
    }
}
