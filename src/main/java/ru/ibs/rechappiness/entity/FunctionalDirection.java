package ru.ibs.rechappiness.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "functional_directions")
public class FunctionalDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "functionalDirection")
    private List<Project> projects;

    @Column(name = "name")
    private String name;

}
