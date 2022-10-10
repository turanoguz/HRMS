package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.dataAcces.abstracts.JobTitleDao;
import com.kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao=jobTitleDao;
	}
	
	@Override
	public List<JobTitle> getAll() {
		
		return this.jobTitleDao.findAll();
	}
	

}
