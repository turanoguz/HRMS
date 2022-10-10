package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
}
