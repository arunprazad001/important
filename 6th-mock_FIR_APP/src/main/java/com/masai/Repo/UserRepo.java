package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.firstName=?1 AND u.password=?2")
	public User getUserByUsernameAndpassword(String firstname, String password);
	
	public User findByMobileAndPassword(String mobile, String password);
	
	public User findByMobile(String mobile);


}
