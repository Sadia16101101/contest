package com.example.software_a4.service;

import com.example.software_a4.controller.ContestRegistration;
import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import com.example.software_a4.repository.ContestRepository;
import com.example.software_a4.repository.PersonRepository;
import com.example.software_a4.repository.TeamMember;
import com.example.software_a4.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class ContestService {
    private ContestRepository contestRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PersonRepository personRepository;

    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }


    public List<Contest> getAllContest(String name) {
        List<Contest> contests = contestRepository.findAll();
        return contestRepository.findAll();
    }

    public Contest contestRegistration(Long contestId, ContestRegistration contestRegistration){
        Contest contest = contestVerification(contestId);
        if(contest == null){
            return null;
        }
        if(personValidation(contestRegistration.getCoach(),contestRegistration.getMembers())){
            Person savedCoach = personRepository.save(contestRegistration.getCoach());
            Team savedTeam = contestRegistration.getTeam();
            savedTeam.setCoach(savedCoach);
            List<Person> newMembers = new ArrayList<>();
            for(Person p : contestRegistration.getMembers()){
                if(p.getId() == null)
                    newMembers.add(personRepository.save(p));
                else{
                    newMembers.add(personRepository.findById(p.getId()).get());
                }

            }
            savedTeam.setMembers(newMembers);
            savedTeam = teamRepository.save(savedTeam);
            Contest updatedContest = contestRepository.findById(contestId).get();
            List<Team> teams = updatedContest.getTeamAttend();
            teams.add(savedTeam);
            updatedContest.setTeamAttend(teams);
            contestRepository.save(updatedContest);
            return updatedContest;
        }
        return null;

    }
    public Boolean personValidation(Person coach, List<Person> members){
        Optional<Person> currentCoach = personRepository.findByEmail(coach.getEmail());
        if(currentCoach.isPresent()){
            return false;
        }
        List<String> allCurrentEmails = new ArrayList<>();
        for(Person person : members){
            if(person.getId() != null){
                Optional<TeamMember> teamMember = teamRepository.findByMemberId(person.getId());
                if(teamMember.isPresent()){
                    return false;
                }
                Optional<Person> existingPerson = personRepository.findById(person.getId());
                person.setEmail(existingPerson.get().getEmail()); //setting the email
                Date date = existingPerson.get().getBirthday();
                int dateThen = date.getYear();
                Date d = new Date();
                int now = d.getYear();
                int age = now - dateThen;
                if (age > 24)
                    return false;
                //else allCurrentEmails.add(person.getEmail());
            }
            Optional<Person> memberByEmail = personRepository.findByEmail(person.getEmail());
            if(allCurrentEmails.contains(person.getEmail())){
                return false;
            }
            if(person.getId() == null){
                Date date = person.getBirthday();
                int dateThen = date.getYear();
                Date d = new Date();
                int now = d.getYear();
                int age = now - dateThen;
                if (age > 24)
                    return false;
                else allCurrentEmails.add(person.getEmail());
            }

        }

        return true;

    }
    public Contest contestVerification(Long contestId) {
        Contest contest = new Contest();
        Optional<Contest> c1 = contestRepository.findById(contestId);
        if(c1.isPresent()){
            if(!c1.get().getEdit()){
                return null;
            }

            contest = c1.get();
            int a = contest.getCapacity();
            int b = contest.getTeamAttend().size();
            int slot = (a - b);
            if (slot == 0)
                 return null;
            else
                return contest;


        }else{
            return null;
        }

    }

    public Contest editContest(Contest contest) {
        Optional<Contest> c1 = contestRepository.findById(contest.getId());
        Contest c3= new Contest();
        if(c1.isPresent()) {
            c3=c1.get();
            if (c3.getEdit() == false) {
                return null;
            }
            c3.setName(contest.getName());
            c3.setCapacity(contest.getCapacity());
        }
        contestRepository.save(c3);
        return c3;
    }
    public Contest setEditable(Long id){

        Optional<Contest> c1 = contestRepository.findById(id);
        Contest c3= new Contest();
        if(c1.isPresent()) {
            c3=c1.get();
            if (c3.getEdit() == false) {
                //c3.setEdit(c.getEdit());
                c3.setEdit(Boolean.TRUE);
            }
        }
        contestRepository.save(c3);
        return c3;

    }

    public Contest setReadOnly(Long id){

        Optional<Contest> c1 = contestRepository.findById(id);
        Contest c3= new Contest();
        if(c1.isPresent()) {
            c3=c1.get();
            if (c3.getEdit() == true) {
                //c3.setEdit(c.getEdit());
                c3.setEdit(Boolean.FALSE);
            }
        }
        contestRepository.save(c3);
        return c3;

    }

}
