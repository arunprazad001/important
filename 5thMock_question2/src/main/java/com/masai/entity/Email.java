package com.masai.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mail_id;
	private String email;
	private String created_date;
	
	 @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	
	public Email() {
		// TODO Auto-generated constructor stub
	}


	public Email(int mail_id, String email, String created_date, User user) {
		super();
		this.mail_id = mail_id;
		this.email = email;
		this.created_date = created_date;
		this.user = user;
	}


	public int getMail_id() {
		return mail_id;
	}


	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Email [mail_id=" + mail_id + ", email=" + email + ", created_date=" + created_date + ", user=" + user
				+ "]";
	}
	
	
}
