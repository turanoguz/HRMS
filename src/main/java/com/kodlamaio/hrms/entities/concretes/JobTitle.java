package com.kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_titles")
public class JobTitle {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title",nullable = false)
	@NotNull(message = "İş adı boş bırakılamaz.")
	private String title;
	
	/*
	@OneToMany(mappedBy = "jobTitle")
	private List<JobPosting>  jobPosting =new ArrayList<>();
*/
}