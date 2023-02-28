package com.masai.Service;

import java.util.*;

import com.masai.Entity.Email;
import com.masai.Entity.User;

public interface UserServices {
	public String RegisterUser(User user);
	public List<User> getAllUsers();
	 public User updateUser(int id, User user);
	 public String deleteUser(int id); 
	 public List<Email> viewAllMails();
}
