package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Street;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreetDto {
    private Long id;
    private String name;

    public Street toDomain() {
        Street street = new Street();
        street.setId(id);
        street.setName(name);
        return street;
    }

    public static StreetDto toDto(Street street) {
        StreetDto streetDto = new StreetDto();
        streetDto.setId(street.getId());
        streetDto.setName(street.getName());
        return streetDto;
    }
}
