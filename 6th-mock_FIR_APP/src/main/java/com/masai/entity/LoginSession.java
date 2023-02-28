package com.masai.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;


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