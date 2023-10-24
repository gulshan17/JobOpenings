package com.gk.JobOpenings;

import com.gk.JobOpenings.entity.Job;
import com.gk.JobOpenings.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobOpeningsApplication implements CommandLineRunner {

	@Autowired
	private JobRepository jobRepository;

	public static void main(String[] args) {
		SpringApplication.run(JobOpeningsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Job job = new Job("Software Engineer", "Full Stack engineer experience with Python, Java or similar high level languages", "4-5 years experience", "Bengaluru, Karnataka");
		jobRepository.save(job);

		job = new Job("Data Engineer", "Data Engineer experience with Python, Java, Scala, PySpark, Azure Databricks", "4-5 years experience", "Bengaluru, Karnataka");
		jobRepository.save(job);

		job = new Job("Software Engineer 2", "Gathering functional requirements, developing technical specifications, and project & test planning\n" +
				"Hands-on development. Write the highest quality code with utmost attention to scalability and performance\n" +
				"Designing/developing web software, prototypes, or proofs of concepts\n" +
				"Resolve defects/bugs in pre-production, production, and post-release patches\n" +
				"Work cross-functionally with various Intuit teams: product management, various product lines, or business units to drive forward results\n" +
				"Experience with Agile Development, SCRUM, or Extreme Programming methodologies", "2+ years experience developing web, software, or mobile applications\n" +
				"BS/MS in Computer Science or equivalent work experience\n" +
				"2+ years of professional or open-source experience with a JavaScript MVC toolkit in a Single Page Architecture. (React, AngularJS, Dojo) \n" +
				"1+ years experience with web services (consuming or creating) with GraphQL or REST \n" +
				"Strong OOP design and coding skills\n" +
				"Experience with the entire Software Development Life Cycle (SDLC)\n" +
				"Experience with unit testing and automation with the goal of producing high quality applications\n" +
				"Solid communication skills: Demonstrated ability to explain complex technical issues to both technical and non-technical audiences", "Bengaluru, Karnataka");
		jobRepository.save(job);
	}
}
