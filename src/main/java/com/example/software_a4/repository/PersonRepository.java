package com.example.software_a4.repository;

import com.example.software_a4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    public List<Person> findByName(String name);
    Optional<Person> findByEmail(String email);
}
