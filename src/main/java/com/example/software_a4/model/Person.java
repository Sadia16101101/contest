package com.example.software_a4.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
//import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
//import javax.validation.constrants.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthday;

    @Column
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String university;

}
