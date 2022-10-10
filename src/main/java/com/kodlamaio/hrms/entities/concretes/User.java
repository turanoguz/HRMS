package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id",nullable = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	@NotBlank(message = "email alanı boş bırakılamaz.")
	@NotNull(message = "email alanı boş bırakılamaz.")
	@Email(message = "Lütfen geçerli bir formatta mail giriniz.")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "Parola alanı boş bırakılamaz.")
	@NotNull(message = "Parola alanı boş bırakılamaz.")
	private String password;
	
	
	

}
