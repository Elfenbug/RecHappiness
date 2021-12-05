package ru.ibs.rechappiness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Country;
import ru.ibs.rechappiness.model.Project;
import ru.ibs.rechappiness.model.Street;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
