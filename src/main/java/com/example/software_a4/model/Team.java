package com.example.software_a4.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer rank = null;


    @Enumerated(EnumType.ORDINAL)
    private State sta = State.PENDING;


    @ManyToMany(cascade=CascadeType.MERGE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Person> members = new ArrayList<>();



    @OneToOne(cascade = CascadeType.MERGE) // owning-side
    @JoinColumn(name = "person_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Person coach;



    @OneToOne(cascade = CascadeType.MERGE)
    @Nullable// owning-side
    @JoinColumn(name = "clone_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team clone;



    @ManyToOne(fetch = FetchType.EAGER)// owning-side
    //@JoinColumn(name = "contest_id")
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    //@JsonIdentityReference(alwaysAsId = true)
    private Contest contest;


    public enum State {
        ACCEPTED,PENDING,CANCELED;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();

    }






}