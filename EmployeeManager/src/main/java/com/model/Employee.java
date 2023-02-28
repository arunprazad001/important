package com.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int employee_id;
    private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int salary;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="manager_id")
	private Manager managerid;
	
}
