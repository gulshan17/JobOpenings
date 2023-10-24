package com.gk.JobOpenings.repository;

import com.gk.JobOpenings.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
