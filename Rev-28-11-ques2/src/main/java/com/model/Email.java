package com.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int email_id;
	private String email;
	private String created_date;
	private User user;
	
	
	
	
}
