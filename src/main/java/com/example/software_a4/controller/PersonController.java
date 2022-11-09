package com.example.software_a4.controller;

import com.example.software_a4.model.Person;
import com.example.software_a4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/allperson", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersons() {
        return new ResponseEntity(personService.getAllPerson(), HttpStatus.OK);

    }

    @GetMapping("person/{id}")
    public Person personById(@PathVariable("id") Long id) {
        return personService.getByPersonsID(id);
    }
    @GetMapping("persons/{name}")
    public ResponseEntity<List<Person>> getStudents(@RequestParam String name) {
        List<Person> persons = personService.getStudents(name);
        return new ResponseEntity<>(persons, new HttpHeaders(), HttpStatus.OK);
    }

}
