package com.gk.JobOpenings.service.impl;

import com.gk.JobOpenings.entity.Application;
import com.gk.JobOpenings.repository.ApplicationRepository;
import com.gk.JobOpenings.repository.JobRepository;
import com.gk.JobOpenings.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public void save(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}
