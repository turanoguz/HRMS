package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);

}
