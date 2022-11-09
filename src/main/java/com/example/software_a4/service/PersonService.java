package com.example.software_a4.service;

import com.example.software_a4.model.Person;
import com.example.software_a4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getAllPerson() {return personRepository.findAll();}


    public Person getByPersonsID(@PathVariable("id") Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        else return null;
    }
    public List<Person> getStudents(String name) {
            return personRepository.findByName(name);
        }
    }





