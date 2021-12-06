package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Overtime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OvertimeDto {
    private Long id;
    private String name;

    public Overtime toDomain() {
        Overtime overtime = new Overtime();
        overtime.setId(id);
        overtime.setName(name);
        return overtime;
    }

    public static OvertimeDto toDto(City city) {
        OvertimeDto overtimeDto = new OvertimeDto();
        overtimeDto.setId(city.getId());
        overtimeDto.setName(city.getName());
        return overtimeDto;
    }
}
