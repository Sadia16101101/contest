package com.example.software_a4.controller;

import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ContestRegistration {
    @NotNull(message = "Team is required")
    private Team team;

    @NotNull(message = "Coach is required")
    private Person coach;


    @Size(min = 1, max = 3, message = "Team members should be between 1 and 3")
    private List<Person> members;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
