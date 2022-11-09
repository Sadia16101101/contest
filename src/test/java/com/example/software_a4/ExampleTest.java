package com.example.software_a4;


import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import com.example.software_a4.repository.ContestRepository;
//import org.junit.Test;
import com.example.software_a4.repository.PersonRepository;
import com.example.software_a4.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class ExampleTest {

    @Autowired
    ContestRepository contestRepository;


    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PersonRepository personRepository;


    @Test
    public void demoTest() {

        Contest contest = new Contest();
        contest.setName("Baylor Bear");
        contest.setCapacity(5);
        contest.setRegistration_allowed(Boolean.TRUE);
        //entityManager.persist(contest);
        contest.setRegistration_from(new Date(122, 9, 8));
        contest.setRegistration_to(new Date(122, 9, 12));

    }

    @Test
    public void teamMembers() {
        List<Team> teams = teamRepository.findAll();
        for (Team t : teams) {
            System.out.println("::::::: Team Name: " + t.getName());
            for (Person p : t.getMembers()) {
                if(t.getMembers().size()>3){
                    System.out.println("Cannot have more than 3 members");
                }
                else{
                    System.out.println("######## Member Name: " + p.getName());
                }
            }
            System.out.println();
        }
    }

    @Test
    public void teamMembers2() {
        List<Contest> contests = contestRepository.findByName("Tiger");
        for (Contest contest : contests) {
            for (Team t : contest.getTeamAttend()) {
                System.out.println("::::::: Team Name: " + t.getName());
                for (Person p : t.getMembers()) {
                    System.out.println("######## Member Name: " + p.getName());
                }
                System.out.println();
            }

        }
    }



    @Test
    public void membersAge() {
        List<Person> members = personRepository.findAll();
        Map<Long, List<String>> map = new HashMap<>();
        for (Person p : members) {
            System.out.println("######## Member Name: " + p.getName());
            System.out.println("######## Member BirthDate: " + p.getBirthday());
            System.out.println("######## Member University: " + p.getUniversity());

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(p.getBirthday());
            long year = calendar.get(Calendar.YEAR);

//            long years = p.getBirthDate().getYear();

            if(!map.containsKey(year))
                map.put(year, new ArrayList<>());
            map.get(year).add(p.getName());
        }

        for (Map.Entry<Long, List<String>> entry : map.entrySet())
            System.out.println("BirthYear = " + entry.getKey() +
                    ", Same year Group = " + entry.getValue());

    }

    @Test
    public void contest() {
        List<Contest> contests = contestRepository.findAll();
        for (Contest contest : contests) {
            System.out.println("######## Contest Capacity: " +contest.getCapacity());//contest capacity
            System.out.println("######## Current Occupency: " +contest.getTeamAttend().size());//current ocupency
            int a= contest.getCapacity();
            int b= contest.getTeamAttend().size();
            System.out.println("######## Available Slot: " +(a-b));//current ocupency



        }
    }






}
