package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.City;
import ru.ibs.rechappiness.model.Users;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;

    public Users toDomain() {
        Users users = new Users();
        users.setId(id);
        users.setUsername(username);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        return users;
    }

    public static UsersDto toDto(Users users) {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setUsername(users.getUsername());
        usersDto.setFirstName(users.getFirstName());
        usersDto.setLastName(users.getLastName());
        return usersDto;
    }
}
