package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult< List<Candidate>> getAll();
	Result add(Candidate candidate);
	

}
