package com.gk.JobOpenings.controller;

import com.gk.JobOpenings.entity.Applicant;
import com.gk.JobOpenings.entity.Application;
import com.gk.JobOpenings.entity.JobApplication;
import com.gk.JobOpenings.service.ApplicantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/addapplicant")
    public String addApplicant(Model model, @RequestParam(required = false, defaultValue = "-1",value="jobId") Long jobId) {
        Applicant applicant = new Applicant();
        model.addAttribute("applicant", applicant);
        model.addAttribute("jobId", jobId);
        return "addapplicant";
    }

    @PostMapping("/insertapplicant")
    public String receiveApplication(Model model, @ModelAttribute("applicant") Applicant applicant, @RequestParam(required = false, defaultValue = "-1",value="jobId") Long jobId) {
        applicantService.save(applicant);
        if(jobId != -1) {
            return "redirect:/saveapplication?jobId=" + jobId + "&applicantId=" + applicant.getId();
        }
        return "redirect:/";
    }

    @PostMapping("/checkapplicant")
    public String receiveApplication(@ModelAttribute("applicant") JobApplication jobApplication) {
        Applicant applicant = applicantService.getApplicantByEmail(jobApplication.getEmail());
        if(applicant == null) {
            return "redirect:/addapplicant?jobId=" + jobApplication.getJobId();
        }

        return "redirect:/saveapplication?jobId=" + jobApplication.getJobId() + "&applicantId=" + applicant.getId();
    }

    @GetMapping("/applicants")
    public String viewApplications(Model model) {
        model.addAttribute("applicants", applicantService.getAllApplicants());
        return "applicants";
    }
}
