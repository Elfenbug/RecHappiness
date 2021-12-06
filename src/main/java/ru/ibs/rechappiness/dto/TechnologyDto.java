package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Technology;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TechnologyDto {
    private Long id;
    private String name;

    public Technology toDomain() {
        Technology technology = new Technology();
        technology.setId(id);
        technology.setName(name);
        return technology;
    }

    public static TechnologyDto toDto(City city) {
        TechnologyDto technologyDto = new TechnologyDto();
        technologyDto.setId(city.getId());
        technologyDto.setName(city.getName());
        return technologyDto;
    }
}
