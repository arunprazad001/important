package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.UserException;
import com.masai.Repo.UserRepo;
import com.masai.entity.User;



public class UserImpl implements UserService{

	@Autowired
	private UserRepo uRepo;
	
	@Override
	public List<User> viewAllUsers()throws UserException {
		List<User>l=uRepo.findAll();
		if(l.size()==0) {
			throw new UserException("No users found");
		}else {
			return l;
		}
	}

	@Override
	public User viewUserbyId(int id) {
		Optional<User> opt = uRepo.findById(id);
		if (opt.isPresent()) {
			User puser = opt.get();
			return puser;
		} else {
			throw new UserException("User Doesn't Exist with Id!: " + id);
		}
	}

	@Override
	public User Adduser(User user) {
		User saveduser = uRepo.save(user);
		return saveduser;
	}

	@Override
	public String DeleteUser(User user) {
		Optional<User> opt = uRepo.findById(user.getid());
		if (opt.isPresent()) {
			uRepo.delete(user);
			return user;
		} else {
			throw new UserException("User Doesn't Exist ! ");
		}
	}

}
