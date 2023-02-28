package com.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	    private int manager_id;
	    private String firstName;
		private String lastName;
		private String email;
		private String phone;
		private int salary;
		@OneToMany(cascade=CascadeType.ALL,mappedBy="Manager")
		private List<Employee> employees=new ArrayList<>();
}


