package com.gk.JobOpenings.controller;

import com.gk.JobOpenings.entity.Applicant;
import com.gk.JobOpenings.entity.Application;
import com.gk.JobOpenings.entity.JobApplication;
import com.gk.JobOpenings.service.ApplicantService;
import com.gk.JobOpenings.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/applyjob")
    public String applyJob(Model model, @RequestParam(required = true, value="jobId") Long jobId) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobId(jobId);
        model.addAttribute("jobApplication", jobApplication);
        return "email";
    }

    @GetMapping("/saveapplication")
    public String addApplicant(Model model, @RequestParam(required = true, value="jobId") Long jobId, @RequestParam(required = true, value="applicantId") Long applicantId) {
        if((jobId != -1) && (applicantId != -1)) {
            Application application = new Application(jobId, applicantId, "applied");
            applicationService.save(application);
            return "redirect:/applications";
        }
        return "redirect:/";
    }

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        model.addAttribute("applications", applicationService.getAllApplications());
        return "applications";
    }
}
