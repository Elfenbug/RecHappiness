package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantDto {
//    private Long id;
//    private String name;
//
//    public City toDomain() {
//        City city = new City();
//        city.setId(id);
//        city.setName(name);
//        return city;
//    }
//
//    public static ParticipantDto toDto(City city) {
//        ParticipantDto cityDto = new ParticipantDto();
//        cityDto.setId(city.getId());
//        cityDto.setName(city.getName());
//        return cityDto;
//    }
}
