//package ru.ibs.rechappiness.service.impl;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import ru.ibs.rechappiness.service.CityService;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
//class CityServiceImplTest {
//
//    @Autowired
//    ProjectServiceImpl service;
//
////    @Autowired
////    ModelMapper modelMapper;
//
//    @MockBean
//    CityService cityService;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getAllCities() {
//        TeamInfo teamInfo = new TeamInfo();
//        WorkingConditions workingConditions = new WorkingConditions();
//        ProjectType projectType = new ProjectType();
//        LocalDateTime created = LocalDateTime.now();
//        LocalDateTime updated = LocalDateTime.now();
//        final ProjectDTO projectDTO = new ProjectDTO(1L, "prject name", "customer", "stage", true, "2021-12-01 00:52:05.860462",
//                created, updated, "func_direction", "subject_area", "description",
//                "problem_to_solve", "projectAuthor", "technology", 4,
//                true, true, teamInfo, projectType, workingConditions);
//        final Project newProject = MapperUtil.DtoToEntityConv(projectDTO, modelMapper);
//        service.addProject(projectDTO);
//
//        verify(dao, times(1)).save(newProject);
//    }
//
//    @Test
//    void getCity() {
//    }
//
//    @Test
//    void saveCity() {
//    }
//
//    @Test
//    void deleteCity() {
//    }
//
//    @Test
//    void updateCity() {
//    }
//}