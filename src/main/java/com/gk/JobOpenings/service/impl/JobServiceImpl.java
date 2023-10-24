package com.gk.JobOpenings.service.impl;

import com.gk.JobOpenings.entity.Job;
import com.gk.JobOpenings.repository.JobRepository;
import com.gk.JobOpenings.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
