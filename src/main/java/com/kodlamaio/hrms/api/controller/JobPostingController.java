package com.kodlamaio.hrms.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobPostingService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/jobPostings")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		
		return this.jobPostingService.add(jobPosting);
	}
	
	
}
