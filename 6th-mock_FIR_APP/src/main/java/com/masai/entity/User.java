package com.masai.entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Pattern(regexp="[a-zA-Z]{3-15}",message="First Name must not contain numbers or special characters")
	private String firstName;
	@Pattern(regexp="[a-zA-Z]{3-15}",message="Last Name must not contain numbers or special characters")
	private String lastName;
	@Size(min=10,max=10,message="Mobile number must have 10 digits")
	@Pattern(regexp="[6-9]{1}[0-9]{9}")
	private String mobileNumber;
	
	private String address;
	
	@Min(8)
	private int age;
	
	@Pattern(regexp="(?male|female|transgender)#")
    private String gender;
	
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should looke like cdDe12&#")
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Fir>firlist=new ArrayList<>();
	
	
}
