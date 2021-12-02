package ru.ibs.rechappiness.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "stakeholders")
    private int stakeholder;

    @Column(name = "descriprion")
    private String descriprion;

    @Column(name = "count_developers")
    private int countDeveloper;

    @Column(name = "count_analitics")
    private int countAnalitic;

    @Column(name = "testers")
    private boolean tester;

    @Column(name = "technical_writers")
    private boolean technicalWriter;

    @Column(name = "check_ready")
    private boolean checkReady;

    @Column(name = "team_date")
    private Date teamDate;

    @Column(name = "check_documentation")
    private boolean checkDocumentation;

    @Column(name = "gost")
    private boolean gost;

    @Column(name="projectTask")
    private String projectTask;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "functional_direction_id")
    private FunctionalDirection functionalDirection;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "subject_areas_id")
    private SubjectArea subjectArea;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "project_stage_id")
    private ProjectStage projectStage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "methodology_id")
    private Methodology methodology;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "kind_develop_id")
    private KindDevelop kindDevelop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Location> locations;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "overtime_id")
    Overtime overtime;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "project_has_tecchnologies"
            , joinColumns = @JoinColumn(name = "projects_id")
            , inverseJoinColumns = @JoinColumn(name = "technologies_id"))
    private List<Technology> technologies;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="user_id")
    private Users user;





    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    private List<Role> roles;

}
