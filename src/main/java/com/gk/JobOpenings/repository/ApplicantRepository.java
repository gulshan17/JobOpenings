package com.gk.JobOpenings.repository;

import com.gk.JobOpenings.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Query("SELECT a.id FROM Applicant a WHERE a.email = ?1")
    List<String> findIdByEmail(@Param("email") String email);
}
