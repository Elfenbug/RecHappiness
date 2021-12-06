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

    public Location toDomain() {
        Location location = new Location();
        location.setId(id);
        location.setName(name);
        location.setIndex(index);
        location.setCountry(country.toDomain());
        location.setCity(city.toDomain());
        location.setStreet(street.toDomain());
        location.setHouseNumber(houseNumber);
        location.setFlat(flat);
        return location;
    }

    public static LocationDto toDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setIndex(location.getIndex());
        locationDto.setCountry(CountryDto.toDto((location.getCountry())));
        locationDto.setCity(CityDto.toDto(location.getCity()));
        locationDto.setStreet(StreetDto.toDto((location.getStreet())));
        locationDto.setHouseNumber(location.getHouseNumber());
        locationDto.setFlat(location.getFlat());
        return locationDto;
    }
}
