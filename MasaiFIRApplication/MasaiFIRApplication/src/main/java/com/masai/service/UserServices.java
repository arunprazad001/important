package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.entity.User;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;



public interface UserServices {

	public User insertUser(User user) throws UserException;

	public User updateUser(User user) throws UserException, LoginException;

	public User deleteUser(Integer userId) throws UserException, LoginException;

	public List<User> getAllUsers() throws UserException, LoginException;

	public User getUserById(Integer userId)throws UserException;
}
