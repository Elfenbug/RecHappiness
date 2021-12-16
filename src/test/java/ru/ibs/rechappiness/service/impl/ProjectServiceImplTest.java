package ru.ibs.rechappiness.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.ibs.rechappiness.dto.*;
import ru.ibs.rechappiness.mapper.ProjectMapper;
import ru.ibs.rechappiness.model.*;
import ru.ibs.rechappiness.repository.ProjectRepository;
import ru.ibs.rechappiness.service.ProjectService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Autowired
    ProjectService projectService;

    @MockBean
    ProjectRepository projectRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProjects() {
        Project projectOne = new Project();
        Project projectTwo = new Project();
        List<Project> projectList = new ArrayList<>();
        projectList.add(projectOne);
        projectList.add(projectTwo);
        when(projectRepository.findAll()).thenReturn(projectList);
        List<ProjectDto> newProjectList = projectService.getAllProjects();
        assertEquals(2, newProjectList.size());
        verify(projectRepository, times(1)).findAll();
    }

//    @Test
//    void getProject() {
//        Project project = new Project(1L, "name", LocalDate.now(), 1, "description", "functionalDirection", 2, 3, true, false, false, LocalDate.now(),
//                true, "projectTask", new Customer(1L, "name", new ArrayList<>()), new SubjectArea(1L, "name", new ArrayList<>()), new ProjectStage(1L, "name", new ArrayList<>()),
//                new ProjectType(1L, "name", new ArrayList<>()), new Methodology(1L, "name", new ArrayList<>()), new KindDevelop(1L, "name", new ArrayList<>()),
//                new HashSet<Location>(), new Overtime(1L, "name", new ArrayList<>()), new HashSet<Technology>(), new Users(1L, "name", "firstname", "lastname"),
//                LocalDate.now(), LocalDate.now(), "schedule", "author", false, true);
//
//        when(projectRepository.findProjectById(1L)).thenReturn(project);
//
//        assertEquals(project.getName(), projectService.getProject(1L).getName());
//        verify(projectRepository, times(1)).findProjectById(1L);
//    }

    @Test
    void saveProject() {
        ProjectDto projectDto = new ProjectDto(1L, "name", new CustomerDto(), "2021-12-12", 1, "description", 1, 1, true, false, true, "2021-12-12", true,
                "projectTask", "functionalDirection", new SubjectAreaDto(), new ProjectStageDto(), new MethodologyDto(),
                new KindDevelopDto(), new HashSet<>(), new OvertimeDto(), new HashSet<>(), "schedule", "author", "2021-12-12", "2021-12-12", false, true, "fix", "po", "mvp", "zero");
        projectService.saveProject(projectDto);
        Project newProject = ProjectMapper.INSTANCE.toProject(projectDto);
        verify(projectRepository, times(1)).save(newProject);
    }

    @Test
    void deleteProject() {
        Project project = new Project(1L, "name", LocalDate.now(), 1, "description", "functionalDirection", 2, 3, true, false, false, LocalDate.now(),
                true, "projectTask", new Customer(), new SubjectArea(), new ProjectStage(), new Methodology(), new KindDevelop(),
                new HashSet<>(), new Overtime(), new HashSet<>(), new Users(), LocalDate.now(), LocalDate.now(), "schedule", "author", false, true, "fix", "po", "mvp", "zero");
        List<Project> projectList = new ArrayList<>();
        projectList.add(project);
        projectService.deleteProject(1L);
        assertNull(projectRepository.findProjectById(1L));
    }

    @Test
    void updateProject() {
        ProjectDto projectDto = new ProjectDto(1L, "name", new CustomerDto(), "2021-12-12", 1, "description", 1, 1, true, false, true, "2021-12-12", true,
                "projectTask", "functionalDirection", new SubjectAreaDto(), new ProjectStageDto(), new MethodologyDto(),
                new KindDevelopDto(), new HashSet<>(), new OvertimeDto(), new HashSet<>(), "schedule", "author", "2021-12-12", "2021-12-12", false, true,"fix","po","mvp","zero");

        Project newProject = ProjectMapper.INSTANCE.toProject(projectDto);

        Project project = new Project(1L, "name", LocalDate.now(), 1, "description", "functionalDirection", 2, 3, true, false, false, LocalDate.now(),
                true, "projectTask", new Customer(), new SubjectArea(), new ProjectStage(), new Methodology(), new KindDevelop(),
                new HashSet<>(), new Overtime(), new HashSet<>(), new Users(), LocalDate.now(), LocalDate.now(), "schedule", "author", false, true,"fix","po","mvp","zero");

        projectService.updateProject(projectDto, 1L);

        when(projectRepository.findProjectById(1L)).thenReturn(project);
        when(projectRepository.save(newProject)).thenReturn(newProject);
        //  verify(projectRepository, times(1)).save(newProject);
    }
}