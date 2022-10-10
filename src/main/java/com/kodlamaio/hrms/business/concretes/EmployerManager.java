package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.ErrorResult;
import com.kodlamaio.hrms.core.result.Result;
import com.kodlamaio.hrms.core.result.SuccesDataResult;
import com.kodlamaio.hrms.core.result.SuccesResult;
import com.kodlamaio.hrms.dataAcces.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccesDataResult<List<Employer>>(this.employerDao.findAll(),"Başarıyla listelendi.");
	}
	
	

	@Override
	public Result add(Employer employer) {
		
		return checkEmployer(employer);
	}
	
	
	private Result checkEmployer(Employer employer) {
		if(this.employerDao.existsByemail(employer.getEmail())) {
			System.out.println("Girrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			return new ErrorResult("Mail adresi sistemde kayıtlı.");
		}
		if(this.employerDao.existsByCompanyName(employer.getCompanyName())) {
			return new ErrorResult("Şirket adı sistemde kayıtlı."); 
		}
		
		if(this.employerDao.existsByPhoneNumber(employer.getPhoneNumber())) {
			return new ErrorResult("Numara sistemde kayıtlı.");
		}
		if(this.employerDao.existsByWebAddress(employer.getWebAddress())) {
			return new ErrorResult("Web adresi sistemde kayıtlı.");
		}
		
		if(!checkEmail(employer)) {
			return new ErrorResult("E mail uzantısı şirket adıyla aynı olmalıdır.");
		}
		this.employerDao.save(employer);
		return new SuccesResult("Kayıt başarılı");
	}
	
	private boolean  checkEmail(Employer employer) {
		String [] splitArr = employer.getEmail().split("@");
		return  splitArr[1].contains(employer.getCompanyName());
	}



	
	
	
	

}
