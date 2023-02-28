package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.LoginSession;


@Repository
public interface LoginSessionDao extends JpaRepository<LoginSession, Integer>{

	public LoginSession findByUserUniqueId(String userUniqueId);
	
	public LoginSession  findByMobile(String mobile);
	
	public LoginSession findByType(String type);
	
}
