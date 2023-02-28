package com.masai.entity;

import java.time.LocalDateTime;


import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fir {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer FirId;
	
	private String crimeDetail ;
	
	private LocalDateTime timeStamp ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="id")
	private User user;
	
	
	
}
