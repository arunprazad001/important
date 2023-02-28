package com.masai.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int UserId;
	@Pattern(regexp="[a-zA-Z]{3-15}",message="First Name must not contain numbers or special characters")
	private String firstName;
	@Pattern(regexp="[a-zA-Z]{3-15}",message="Last Name must not contain numbers or special characters")
	private String lastName;
	@Size(min=10,max=10,message="Mobile number must have 10 digits")
	@Pattern(regexp="[6-9]{1}[0-9]{9}")
	private String mobileNumber;
	@Past
	private LocalDate dateOfBirth ;
	
	private List<Email>emails=new ArrayList<>();
	public void AddEmails(Email email) {
		this.emails.add(email);
	}
}
