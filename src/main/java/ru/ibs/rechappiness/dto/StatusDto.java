package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Status;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusDto {
//    private Long id;
//    private String name;
//
//    public City toDomain() {
//        Status status = new Status();
//        status.setId(id);
//        status.setName(name);
//        return status;
//    }
//
//    public static StatusDto toDto(Status status) {
//        StatusDto statusDto = new StatusDto();
//        statusDto.setId(status.getId());
//        statusDto.setName(status.getName());
//        return statusDto;
//    }
}
