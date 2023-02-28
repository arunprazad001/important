package com.masai.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	@javax.validation.constraints.Email
	private String Email;
	@Pattern(regexp = "[a-zA-Z]")
	private String Firstname;
	@Pattern(regexp = "[a-zA-Z]")
	private String Lastname;
	@Pattern(regexp = "[a-b1-9]{6-12}$")
	private String password;
	@Pattern(regexp = "[1-9]{10}$")
	private String Phone;
	@Past
	private LocalDate DOB;
	@JsonIgnore
	@OneToMany(mappedBy="sendto",cascade=CascadeType.ALL)
	private List<Mail> mails = new ArrayList<Mail>();
	
	
	

}
