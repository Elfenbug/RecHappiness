//package ru.ibs.rechappiness.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "functional_directions")
//public class FunctionalDirection {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "functionalDirection")
//    @JsonIgnore
//    private List<Project> projects;
//
//    @Column(name = "name")
//    private String name;
//
//}
