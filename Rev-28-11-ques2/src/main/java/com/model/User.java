package com.model;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String name;
	private String phoneNo;
	private String dateOfBirth;
	@OneToOne
	@
	private Email email;
	
	
}
