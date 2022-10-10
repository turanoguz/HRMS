package com.kodlamaio.hrms.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.ErrorDataResult;
import com.kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates")
public class CandidateController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult< List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody  @Valid Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors = new HashMap<String,String>();
		
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errors =new ErrorDataResult<>(validationErrors,"Doğrulama hataları.");
		return errors;
		
		
	}
	
	
	
	

}
