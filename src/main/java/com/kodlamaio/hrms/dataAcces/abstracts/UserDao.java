package com.kodlamaio.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
