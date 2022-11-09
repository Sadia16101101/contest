package com.example.software_a4.controller;

import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import com.example.software_a4.service.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller{

//    private SuperRepository superRepository;
//
//    @Autowired
//    public Mycontroller(SuperRepository superRepository){
//        this.superRepository = superRepository;
//    }
//
//    @RequestMapping(value = "/populate", method = RequestMethod.GET)
//    public ResponseEntity populates(){
//        superRepository.populate();
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/persons", method = RequestMethod.GET)
//    public ResponseEntity<Person> getPersons(){
//        return new ResponseEntity(superRepository.getPersons(),HttpStatus.OK);
//
//    }
//
//    @RequestMapping(value = "/teams", method = RequestMethod.GET)
//    public ResponseEntity<Team> getTeams(){
//        return new ResponseEntity(superRepository.getTeams(),HttpStatus.OK);
//
//    }


}
