package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Location;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {
    private Long id;
    private String name;
    private String index;
    private CountryDto country;
    private CityDto city;
    private StreetDto street;
    private String houseNumber;
    private String flat;
}
