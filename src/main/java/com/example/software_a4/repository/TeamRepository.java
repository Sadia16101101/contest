package com.example.software_a4.repository;

import com.example.software_a4.model.Person;
import com.example.software_a4.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    public List<Team> findByName(String name);

    @Query(value = "Select * from team_members where members_id=:memberId",nativeQuery = true)
    Optional<TeamMember> findByMemberId(@Param("memberId")Long memberId);

    List<Team> findAll();

    @Query(value = "SELECT * FROM CONTEST_TEAM WHERE TEAM_ID=:teamId AND CONTEST_ID=:contestId", nativeQuery = true)
    Optional<?> findByTeamIdAndContestId(Long teamId, Long contestId);
}
