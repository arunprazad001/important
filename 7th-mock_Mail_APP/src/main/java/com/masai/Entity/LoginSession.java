package com.masai.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	
	private String mobile;
	private String userUniqueId;
	private LocalDateTime loginTime;
	private String type;
	
}