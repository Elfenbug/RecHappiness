package ru.ibs.rechappiness.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.ibs.rechappiness.model.KindDevelop;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KindDevelopDto {
    private Long id;
    private String name;

    public KindDevelop toDomain() {
        KindDevelop kindDevelop = new KindDevelop();
        kindDevelop.setId(id);
        kindDevelop.setName(name);
        return kindDevelop;
    }

    public static KindDevelopDto toDto(KindDevelop kindDevelop) {
        KindDevelopDto kindDevelopDto = new KindDevelopDto();
        kindDevelopDto.setId(kindDevelop.getId());
        kindDevelopDto.setName(kindDevelop.getName());
        return kindDevelopDto;
    }
}
