package com.example.software_a4.service;

import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import com.example.software_a4.repository.ContestRepository;
import com.example.software_a4.repository.PersonRepository;
import com.example.software_a4.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContestRepository contestRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeam(String name) {
        List<Team> teams = teamRepository.findAll();
        for (Team t : teams) {
            System.out.println("::::::: Team Name: " + t.getName());
            for (Person p : t.getMembers()) {
                System.out.println(t.getMembers().size());

                if (t.getMembers().size() > 3) {
                    System.out.println("Cannot have more than 3 members");
                    return null;
                } else {
                    System.out.println("######## Member Name: " + p.getName());
                }
            }
            System.out.println();
        }
        return teamRepository.findAll();
    }

    public Contest superContestFind(Long contestId) {
        Contest contest = new Contest();
        Optional<Contest> c1 = contestRepository.findById(contestId);
        if (c1.isPresent()) {
            contest = c1.get();
            int a = contest.getCapacity();
            int b = contest.getTeamAttend().size();
            int slot = (a - b);
            if (slot == 0)
                contest = null;

        }
        return contest;
    }
    public Team teamRank(Long teamId){
            //Integer flag=0;
            Team t1 = new Team();
            Optional<Team> t2 = teamRepository.findById(teamId);
            if(t2.isPresent()){
                t1=t2.get();
                if(t1.getRank()<1 || t1.getRank()>6){
                    t1=null;
                }
            }
            return t1;

        }


    public Team promote(Contest contest, Team team){
        Contest c1 = contest;
        Team t1= new Team();
        t1.setSta(team.getSta());
        t1.setRank(team.getRank());
        t1.setCoach(team.getCoach());
        List<Person> members = new ArrayList<>();
        members.addAll(team.getMembers());
        t1.setMembers(members);
        t1.setName(team.getName());
       // t1.setMembers(team.getMembers());
        t1.setClone(team);
        createTeam(t1);
        Optional<Contest> allContest = contestRepository.findById(contest.getId());
        Contest queryContest = allContest.get();
        int a = queryContest.getCapacity();
        int b = queryContest.getTeamAttend().size();
        int slot = (a - b);
        if(slot>=1){
            List<Team> setTeams = new ArrayList<>();
            setTeams.add(t1);
            queryContest.setTeamAttend(setTeams);
            contestRepository.save(queryContest);
        }
        //teamRepository.save(t1);
        return t1;
    }

    public Team editTeam(Long contestId, Team team) {
        //Optional savedTeam = teamRepository.findByTeamIdAndContestId(team.getId(), contestId);
        Optional<Contest> existingContest = contestRepository.findById(contestId);
        if(existingContest.isPresent()){
            if(existingContest.get().getEdit()){
                Optional<Team> t1 = teamRepository.findById(team.getId());
                if(t1.isPresent()){
                    Team t3= t1.get();
                    t3.setId(team.getId());
                    t3.setName(team.getName());
                    t3.setRank(team.getRank());
                    t3.setSta(team.getSta());
                    teamRepository.save(t3);
                    return t3;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}

