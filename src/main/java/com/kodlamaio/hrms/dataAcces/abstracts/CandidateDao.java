package com.kodlamaio.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate	, Integer> {
	
	boolean existsByemail(String email);
	boolean existsByİdentityNumber(String identityNumber);
	
}
