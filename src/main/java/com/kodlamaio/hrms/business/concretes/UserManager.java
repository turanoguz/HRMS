package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.core.result.DataResult;
import com.kodlamaio.hrms.core.result.SuccesDataResult;
import com.kodlamaio.hrms.dataAcces.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccesDataResult<List<User>>(this.userDao.findAll(),"Başarıyla listelendi");
	}
	

}
