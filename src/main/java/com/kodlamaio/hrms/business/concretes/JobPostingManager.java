package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPostingService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.core.result.SuccesDataResult;
import com.kodlamaio.hrms.core.result.SuccesResult;
import com.kodlamaio.hrms.dataAcces.abstracts.JobPostingDao;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	
	
	
	private JobPostingDao jobPostingDao;
	
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}



	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccesDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"Başarıyla listelendi.");
	}



	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccesResult("Kayıt başarılı");
	}
	

}
