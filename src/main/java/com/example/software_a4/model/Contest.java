package com.example.software_a4.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Contest implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private Integer capacity;


    @Column(nullable = true)
    private String name;

    @Column
    private Boolean registration_allowed;

    @Column
    private Boolean edit;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date registration_from;


    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date registration_to;

    @ManyToMany//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CONTEST_MANEGER",
            joinColumns = { @JoinColumn(name = "CONTEST_ID", referencedColumnName = "ID") }, //do not forget referencedColumnName if name is different
            inverseJoinColumns = { @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID") })
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonIgnore
    List<Person> maneger = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL) // inverse-side
    @JoinTable(name = "CONTEST_TEAM",
            joinColumns = {@JoinColumn(name = "CONTEST_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")})
    private List<Team> teamAttend = new ArrayList<>();




    @ManyToOne // owning-side
    @JoinColumn(name = "superContest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Contest supercontest;





}
