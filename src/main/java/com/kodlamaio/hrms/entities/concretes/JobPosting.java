package com.kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name  = "job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "job_description")
	@NotBlank(message = "İş tanımı alanı boş bırakılamaz.")
	@NotNull(message = "İş tanımı alanı boş bırakılamaz.")
	private String jobDescription ;
	
	@Column(name = "number_of_open_positions")
	@NotBlank(message = "Açık pozisyon alanı boş bırakılamaz.")
	@NotNull(message = "Açık pozisyon alanı boş bırakılamaz.")
	private int numberOfOpenPosition;
	
	@Column(name = "salary_min")
	private String salaryMin;
	
	@Column(name = "salary_max")
	private String salaryMax;
	
	@Column(name = "posting_date")
	private Date postingDate;
	
	@Column(name = "closing_date")
	private Date closingDate; 
	
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@ManyToOne(targetEntity = Employer.class,optional = false)
	@JoinColumn(name ="employer_id",nullable = false)
	private Employer employer;
	
	@ManyToOne(targetEntity = JobTitle.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "job_title_id" ,nullable = true)
	private JobTitle jobTitle;
	
	@ManyToOne(targetEntity = City.class ,cascade = CascadeType.ALL)
	@JoinColumn(name="city_id",nullable = true)
	private City city;
	
	@ManyToOne(targetEntity = WorkingTime.class)
	@JoinColumn(name = "working_time_id",nullable = true)
	private WorkingTime workingTime;
	
	@ManyToOne(targetEntity = WorkingType.class)
	@JoinColumn(name = "working_type_id")
	private WorkingType workingType;
	

}
