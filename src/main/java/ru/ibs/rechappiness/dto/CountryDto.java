package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.Country;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {
    private Long id;
    private String name;

    public Country toDomain() {
        Country country = new Country();
        country.setId(id);
        country.setName(name);
        return country;
    }

    public static CountryDto toDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }
}
