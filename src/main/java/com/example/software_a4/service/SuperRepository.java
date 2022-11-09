package com.example.software_a4.service;

import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class SuperRepository {

//    @PersistenceContext
//    private EntityManager em;
//    //public void populate() throws Exception {
//
//    public void populate(){
//        Person person = createPerson("Joe", "joe@gmail.com",new Date(002, 9, 8) , "Baylor");
//        Person person2 = createPerson("John", "john@gmail.com", new Date(002, 10, 23), "UTD");
//        Person person3 = createPerson("Bob", "bob@gmail.com", new Date(003, 1, 22), "BRACU");
//        Person person4 = createPerson("Tim", "tim@gmail.com", new Date(005, 5, 8), "MUBC");
//        Person person5 = createPerson("Jimmy", "jimmy@gmail.com", new Date(005, 9, 12), "AUST");
//        Person person6 = createPerson("Tisha", "tisha@gmail.com", new Date(003, 12, 8),"NSU");
//        Person person7 = createPerson("Sadia", "sadia@gmail.com", new Date(006, 9, 8), "FSU");
//        Person person8 = createPerson("Tasmia", "tasmia@gmail.com", new Date(003, 6, 20), "AIUB");
//
//
//
//
//        Contest contest = new Contest();
//        contest.setCapacity(10);
//        contest.setName("Bear");
//        contest.setDate(new Date(122, 10, 8));
//        contest.setRegistration_allowed(Boolean.TRUE);
//        contest.setRegistration_from(new Date(122, 9, 8));
//        contest.setRegistration_to(new Date(122, 9, 12));
//        List<Team> teamattend = new ArrayList<>();
//        List<Person> memberTeam = new ArrayList<>();
//        memberTeam.add(person);
//        memberTeam.add(person2);
//        contest.setManeger(memberTeam);
//        em.persist(contest);
//
//
//        Team team = new Team();
//        team.setName("Big");
//        team.setRank(4);
//        team.setSta(Team.State.ACCEPTED);
//        List<Person> member = new ArrayList<>();
//        member.add(person);
//        member.add(person2);
//        member.add(person7);
//        member.add(person8);
//
//        if(member.size()<=3) {
//            team.setMembers(member);
//            team.setCoach(person3);
//            em.persist(team);
//        }
//
//        Team team1 = new Team();
//        team1.setName("Bigger");
//        team1.setRank(4);
//        team1.setSta(Team.State.ACCEPTED);
//        List<Person> member1 = new ArrayList<>();
//        member1.add(person3);
//        member1.add(person4);
//        team1.setMembers(member1);
//        team1.setCoach(person2);
//        em.persist(team1);
//
//        Team team2 = new Team();
//        team2.setName("Best");
//        team2.setRank(4);
//        team2.setSta(Team.State.ACCEPTED);
//        List<Person> member2 = new ArrayList<>();
//        member2.add(person5);
//        member2.add(person6);
//        team2.setMembers(member2);
//        team2.setCoach(person3);
//        em.persist(team2);
//
//
//
//        Contest contest1 = new Contest();
//        contest1.setName("Tiger");
//        contest1.setCapacity(5);
//        contest1.setDate(new Date(122, 10, 8));
//        contest1.setRegistration_allowed(Boolean.TRUE);
//        contest1.setRegistration_from(new Date(122, 9, 8));
//        contest1.setRegistration_to(new Date(122, 9, 14));
//        List<Contest> subcontestList = new ArrayList<>();
//
//        contest1.setSupercontest(contest);
//        contest.getSubcontests().add(contest1);
//        //subcontestList.add(contest);
//        //contest1.setSubcontests(subcontestList);
//        List<Team> teamattend1 = new ArrayList<>();
//        teamattend1.add(team2);
//        teamattend1.add(team1);
//        teamattend1.add(team);
//        contest1.setTeamAttend(teamattend1);
//        List<Person> submemberTeam = new ArrayList<>();
//        submemberTeam.add(person2);
//        submemberTeam.add(person4);
//        submemberTeam.add(person5);
//        contest.setManeger(submemberTeam);
//
//        em.persist(contest);
//        em.persist(contest1);
//
//
//
//
//    }
//    private Person createPerson(String name, String email, Date birDate, String uni){
//        Person person = new Person();
//        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        //Date birdate = formatter.parse("02/07/1996");
//        person.setBirthDate(birDate);
//        person.setEmail(email);
//        person.setName(name);
//        person.setUniversity(uni);
//        em.persist(person);
//        return person;
//    }
//    public List<Person> getPersons(){
//        return em.createQuery("Select p From Person p").getResultList();
//    }
//
//    public List<Team> getTeams(){
//        return em.createQuery("Select t From Team t").getResultList();
//    }
}
