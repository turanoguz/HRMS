package com.kodlamaio.hrms.entities.concretes;

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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
	
	
	@Column(name = "company_name")
	@NotBlank(message = "Şirket adı boş bırakılamaz.")
	@NotNull(message = "Şirket adı boş bırakılamaz.")
	private String companyName;
	
	@Column(name = "web_address")
	@NotBlank(message = "Web adresi boş bırakılamaz.")
	@NotNull(message = "Web adresi boş bırakılamaz.")
	private String webAddress;
	
	@Column(name = "phone_number")
	@NotBlank(message = "Telefon no boş bırakılamaz.")
	@NotNull(message = "Telefon no boş bırakılamaz.")
	private String phoneNumber;
	

}
