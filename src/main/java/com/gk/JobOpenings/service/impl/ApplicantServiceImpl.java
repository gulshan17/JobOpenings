package com.gk.JobOpenings.service.impl;

import com.gk.JobOpenings.entity.Applicant;
import com.gk.JobOpenings.repository.ApplicantRepository;
import com.gk.JobOpenings.service.ApplicantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Applicant getApplicantById(Long Id) {
        return applicantRepository.getReferenceById(Id);
    }

    @Override
    public Applicant getApplicantByEmail(String email) {
        List<String> ids = applicantRepository.findIdByEmail(email);
        if(!ids.isEmpty()) {
            return getApplicantById(Long.parseLong(ids.get(0)));
        }
        return null;
    }

    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }
}
