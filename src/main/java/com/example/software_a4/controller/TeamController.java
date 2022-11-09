package com.example.software_a4.controller;

import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Team;
import com.example.software_a4.service.ContestService;
import com.example.software_a4.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public ResponseEntity createTeam(@RequestBody Team team) {
        teamService.createTeam(team);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(("/allteam"))
    public ResponseEntity<List<Team>> getTeams(@RequestParam(required = false) String name) {
        List<Team> teams = teamService.getAllTeam(name);
        return new ResponseEntity<>(teams, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/promote")
    public ResponseEntity <?>promote(@RequestParam Long contestId,
                                                 @RequestParam Long teamId) {
        Contest contest= teamService.superContestFind(contestId);
        Team team =teamService.teamRank(teamId);
        if(team!=null && contest!=null) {
            Team team1 = teamService.promote(contest,team);
            return new ResponseEntity<>(team1,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_GATEWAY);
    }

    @PutMapping("/editTeam")
    public ResponseEntity<Team> editTeam(@RequestParam Long contestId, @RequestBody Team team) {
        Team edited = teamService.editTeam(contestId, team);
        return new ResponseEntity<>(edited, new HttpHeaders(), HttpStatus.OK);
    }


}
