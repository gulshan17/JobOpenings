package com.gk.JobOpenings.service;

import com.gk.JobOpenings.entity.Application;

import java.util.List;

public interface ApplicationService {
    void save(Application application);
    List<Application> getAllApplications();
}
