package com.masai.service;
import java.util.*;

import com.masai.Exception.UserException;
import com.masai.entity.User;
public interface UserService {
   public List<User> viewAllUsers() throws UserException;
   public User viewUserbyId(int id)throws UserException;
   public User Adduser(User user)throws UserException;
   public String DeleteUser(User user)throws UserException;
   
}
