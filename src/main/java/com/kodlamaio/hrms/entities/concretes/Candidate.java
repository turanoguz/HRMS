package com.kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User{
	
	@Column(name = "first_name")
	@NotNull(message = "İsim alanı boş bırakılamaz.")
	@NotBlank(message = "İsism alanı boş bırakılamaz.")
	private String firstName;
	
	
	@Column(name = "last_name")
	@NotNull(message = "Soyad alanı boş bırakılamaz.")
	@NotBlank(message = "Soyad alanı boş bırakılamaz.")
	private String lastname;
	
	@Column(name = "identity_number")
	@NotNull(message = "T.C. No alanı boş bırakılamaz.")
	@NotBlank(message = "T.C. No alanı boş bırakılamaz.")
	private String identityNumber;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	

}
