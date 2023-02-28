package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.User;


import jakarta.persistence.NamedQuery;

public interface UserRepo extends JpaRepository<User,Integer> {

	
	
	public User findByMobileAndPassword(String mobile, String password);
	
	public User findByMobile(String mobile);
	
	
}
