package com.masai.Service;

import java.util.List;

import com.masai.beans.Mail;
import com.masai.beans.User;
import com.masai.exceptions.MailException;
import com.masai.exceptions.UserException;

public interface UserService {
	
	public User createCustomer(User user)throws UserException;
	
	public User updateCustomer(User user,String key)throws UserException;
//	
	public List<Mail> checkAllMails(String umail,String key) throws UserException;
//	
	public List<Mail> checkAllStarredMails(String umail,String key) throws UserException;


}
