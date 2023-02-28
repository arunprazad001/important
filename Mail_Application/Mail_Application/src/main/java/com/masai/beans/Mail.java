package com.masai.beans;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@JsonIgnore
	private String sender;
	private LocalDateTime time;
	private String mailContent;
	@JsonIgnore
	private boolean starred;
	private String sendto;
	
	
	
	
	
	
	
	
	

}
