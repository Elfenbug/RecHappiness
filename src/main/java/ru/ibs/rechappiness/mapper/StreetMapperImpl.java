//package ru.ibs.rechappiness.mapper;
//
//import ru.ibs.rechappiness.dto.StreetDto;
//import ru.ibs.rechappiness.model.Street;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StreetMapperImpl implements StreetMapper {
//
//    @Override
//    public List<StreetDto> map(List<Street> streets) {
//        if (streets == null) {
//            return null;
//        }
//
//        List<StreetDto> list = new ArrayList<StreetDto>(streets.size());
//        for (Street street : streets) {
//            list.add(employeeToEmployeeDTO(street));
//        }
//
//        return list;
//    }
//
//    protected StreetDto employeeToEmployeeDTO(Street street) {
//        if (street == null) {
//            return null;
//        }
//
//        StreetDto streetDto = new StreetDto();
//
//        streetDto.setId(street.getId());
//        streetDto.setName(street.getName());
//
//        return streetDto;
//    }
//}
