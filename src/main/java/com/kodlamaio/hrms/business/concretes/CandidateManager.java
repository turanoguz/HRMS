package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.ErrorResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.core.result.SuccesDataResult;
import com.kodlamaio.hrms.core.result.SuccesResult;
import com.kodlamaio.hrms.dataAcces.abstracts.CandidateDao;
import com.kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager  implements CandidateService{

	private CandidateDao candidateDao;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}



	@Override
	public DataResult< List<Candidate>> getAll() {
		return new SuccesDataResult<List<Candidate>>(this.candidateDao.findAll(),"Başarıyla listelendi");
	}




	@Override
	public Result add(Candidate candidate) {
		
		return checkCandidate(candidate);
		
 			
	}
	
	
	private Result checkCandidate(Candidate candidate) {
		if(this.candidateDao.existsByemail(candidate.getEmail())) {
			return new ErrorResult("Mail adresi sistemde kayıtlı");
		}
		if(this.candidateDao.existsByİdentityNumber(candidate.getIdentityNumber())){
			return new ErrorResult("Kimlik numarası sistemde kayıtlı.");
		}
		this.candidateDao.save(candidate);
		return new SuccesResult("Kayıt başarılı.");
		
		
	}
	

}
