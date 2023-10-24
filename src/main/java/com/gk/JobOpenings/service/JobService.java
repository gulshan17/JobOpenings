package com.gk.JobOpenings.service;

import com.gk.JobOpenings.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
}
