package com.kodlamaio.hrms.core.result;

public class SuccesResult extends Result{

	public SuccesResult() {
		super(true);
	}
	
	public SuccesResult(String message) {
		super(true,message);
	}
	

}
