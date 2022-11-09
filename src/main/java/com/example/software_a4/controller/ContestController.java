package com.example.software_a4.controller;

import com.example.software_a4.model.Contest;
import com.example.software_a4.model.Team;
import com.example.software_a4.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3002")
public class ContestController {
    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/contest")
    public ResponseEntity createContest(@RequestBody Contest contest) {
         contestService.createContest(contest);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(("/allcontest"))
    public ResponseEntity<List<Contest>> getContests(@RequestParam(required = false) String name) {
        List<Contest> contests = contestService.getAllContest(name);
        return new ResponseEntity<>(contests, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/contestRegistration")
    public ResponseEntity <?>contestRegistration(@RequestParam(name = "contestId") Long contestId,
                                              @RequestBody @Validated ContestRegistration contestRegistration) {
        System.out.println("got call");
        //Team team= contestService.contestTeamFind(teamId);
        //Contest contest =contestService.contestVerification(contestId);
        Contest contest = contestService.contestRegistration(contestId,contestRegistration);
        System.out.println(contest.getId());
        System.out.println(contestRegistration.getCoach());
        System.out.println(contestRegistration.getMembers().get(2));
        if(contest!=null) {

            return new ResponseEntity<>(contest,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



        @PutMapping("/editContest")
        public ResponseEntity<Contest> editContest(@RequestBody Contest contest) {
        Contest edited1 = contestService.editContest(contest);
        return new ResponseEntity<>(edited1, new HttpHeaders(), HttpStatus.OK);
    }



    @PutMapping("/setEditable/{id}")
    public ResponseEntity<Contest> setEditable(@PathVariable("id") Long id) {
        Contest edited1 = contestService.setEditable(id);
        return new ResponseEntity<>(edited1, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/setReadOnly/{id}")
    public ResponseEntity<Contest> setReadOnly(@PathVariable("id") Long id) {
        Contest edited1 = contestService.setReadOnly(id);
        return new ResponseEntity<>(edited1, new HttpHeaders(), HttpStatus.OK);
    }

@PostMapping("/createContestAssignment")
    public Contest createContestAssignment(@RequestBody Contest contest){
        return contestService.createContest(contest);
}

}
