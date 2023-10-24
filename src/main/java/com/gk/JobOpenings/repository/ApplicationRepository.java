package com.gk.JobOpenings.repository;

import com.gk.JobOpenings.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
