package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Pattern(regexp = "[a-zA-Z]{3-15}", message="First Name must not contain numbers or special characters")
	private String firstName ; 
	
	@Pattern(regexp = "[a-zA-Z]{3-15}", message="Last Name must not contain numbers or special characters")
	private String lastName ;  
	
	@Size(min = 10, max = 10, message = "Mobile number must have 10 digits")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile ; 
	
	private String address ;
	
	@Min(8)
	private Integer age;
	
	@Pattern(regexp = "(?:male|female|transgender)$")
	private String gender; 
	
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should looke like abAb@45")
	private String password ; 
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Fir> fir = new ArrayList<>();
}
