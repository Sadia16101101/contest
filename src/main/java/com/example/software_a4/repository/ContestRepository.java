package com.example.software_a4.repository;

import com.example.software_a4.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestRepository extends JpaRepository<Contest,Long> {
    public List<Contest> findByName(String name);
}
