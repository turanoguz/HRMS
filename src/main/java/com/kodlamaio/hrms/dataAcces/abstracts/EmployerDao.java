package com.kodlamaio.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer	, Integer>{
	
	boolean existsByCompanyName(String companyName);
	boolean existsByWebAddress(String webAddress);
	boolean existsByPhoneNumber(String phoneNumber);
	boolean existsByemail(String email);

}
