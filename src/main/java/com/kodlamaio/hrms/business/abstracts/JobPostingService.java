package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	DataResult<List<JobPosting>> getAll();
	Result add(JobPosting jobPosting);
	

}
