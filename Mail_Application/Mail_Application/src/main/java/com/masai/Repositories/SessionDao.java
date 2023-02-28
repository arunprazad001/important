package com.masai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.beans.CurrentUserSession;
import com.masai.beans.User;


@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, String> {

	
	public  CurrentUserSession  findByUuid(String uuid);

//	public User findByEmail(String email);

	
}
