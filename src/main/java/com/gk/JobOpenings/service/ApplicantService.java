package com.gk.JobOpenings.service;

import com.gk.JobOpenings.entity.Applicant;
import com.gk.JobOpenings.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicantService {

    Applicant getApplicantById(Long Id);
    Applicant getApplicantByEmail(String email);

    void save(Applicant applicant);

    List<Applicant> getAllApplicants();
}
