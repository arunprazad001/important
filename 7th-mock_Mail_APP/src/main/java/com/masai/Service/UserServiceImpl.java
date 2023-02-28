package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Entity.Email;
import com.masai.Entity.User;
import com.masai.Repo.UserRepo;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
	private UserRepo uRepo;
	
	@Override
	public String RegisterUser(User user) {
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Email> viewAllMails() {
		// TODO Auto-generated method stub
		return null;
	}

}
