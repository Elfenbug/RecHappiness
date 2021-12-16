package ru.ibs.rechappiness.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deadline")
    // @JsonFormat(pattern="yyyy-MM-dd")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @Column(name = "stakeholders")
    private int stakeholder;

    @Column(name = "description")
    private String description;

    @Column(name = "functional_directions")
    private String functionalDirection;

    @Column(name = "count_developers")
    private int countDeveloper;

    @Column(name = "count_analytics")
    private int countAnalytic;

    @Column(name = "testers")
    private boolean tester;

    @Column(name = "technical_writers")
    private boolean technicalWriter;

    @Column(name = "check_ready")
    private boolean checkReady;

    @Column(name = "team_date")
    // @JsonFormat(pattern="yyyy-MM-dd")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate teamDate;

    @Column(name = "check_documentation")
    private boolean checkDocumentation;

//    @Column(name = "gost")
//    private boolean gost;

    @Column(name = "project_task")
    private String projectTask;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    //@JsonIgnore
    private Customer customer;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "functional_directions_id")
//    private FunctionalDirection functionalDirection;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_areas_id")
    private SubjectArea subjectArea;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_stages_id")
    private ProjectStage projectStage;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "project_types_id")
//    private ProjectType projectType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "methodologies_id")
    private Methodology methodology;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kind_develops_id")
    private KindDevelop kindDevelop;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @JsonIgnore
    private Set<Location> locations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "overtimes_id")
    private Overtime overtime;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "projects_technologies"
            , joinColumns = @JoinColumn(name = "projects_id")
            , inverseJoinColumns = @JoinColumn(name = "technologies_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Technology> technologies;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "users_id")
    private Users user;

    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated;

    @Column(name = "author")
    private String author;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "draft")
    private boolean isDraft;

    @Column(name = "archive")
    private boolean isArchive;

    @Column(name = "fix_or_t_and_m")
    private String fixOrTandM;

    @Column(name = "po_or_pak")
    private String pOorPak;

    @Column(name = "mvp_or_not")
    private String mvpOrNot;

    @Column(name = "zero_or_modern")
    private String zeroOrModern;

    @PrePersist
    public void doCreateDate() {
        setCreated(LocalDate.now());
    }

    @PreUpdate
    public void doUpdateDate() {
        setUpdated(LocalDate.now());
    }


//    @Column(name = "created")
//    @Temporal(TemporalType.DATE)
////    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate created = new LocalDate();
//
//    @Column(name = "updated")
//    //@Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    //@Version
//    private LocalDate updated;

//    @Column(name=)


    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return id != null && Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
