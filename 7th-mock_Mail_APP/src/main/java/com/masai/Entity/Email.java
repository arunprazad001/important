package com.masai.Entity;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int emailId;
	private String subject;
	private String body;
	private LocalDate sentDate;
	
	@ManyToMany
	@JoinTable(name="user_email",
	joinColumns=@JoinColumn(name="user_id",referencedColumnName="userId"),
	inverseJoinColumns=@JoinColumn(name="email_id",referencedColumnName="emailId")
	)
	private List<User> recepients=new ArrayList<>();
	
	public void AddUser(User user) {
		this.recepients.add(user);
	}
	
}
