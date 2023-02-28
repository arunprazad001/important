package com.masai.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repositories.MailRepo;
import com.masai.Repositories.SessionDao;
import com.masai.Repositories.UserRepo;
import com.masai.beans.CurrentUserSession;
import com.masai.beans.Mail;
import com.masai.beans.User;
import com.masai.exceptions.MailException;
import com.masai.exceptions.UserException;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private SessionDao sdao;
	
	@Autowired
	private MailRepo mr;

	@Override
	public User createCustomer(User user) throws UserException {
		
		Optional<User> prese = ur.findById(user.getEmail());
		
		if(prese.isPresent()) {
			throw new UserException("User already exists");
		}
		
		
		return ur.save(user);
		
	}

	@Override
	public User updateCustomer(User user, String key) throws UserException {
		
		Optional<CurrentUserSession> loggedin = sdao.findById(key);
		
		if(loggedin.isEmpty()) {
			throw new UserException("Please provide a valid key to update a customer");
			
		}
		
		if(loggedin.get().getMailid()==user.getEmail()) {
			return ur.save(user);
		}
		
		throw new UserException("Invalid Customer Details, please login first");
		
		
		
		
	}

	@Override
	public List<Mail> checkAllMails(String umail, String key) throws UserException {
		
		Optional<CurrentUserSession> loggedin = sdao.findById(umail);
		
		if(loggedin.isEmpty()) {
			throw new UserException("User not logged in");
			
		}
		
		Optional<User> u = ur.findById(umail);
		
		if(u.isEmpty()) {
			throw new UserException("User not found by this mail");
		}
		
		
		
		
		
		
		return u.get().getMails();
	}

	@Override
	public List<Mail> checkAllStarredMails(String umail,String key) throws UserException {
		
		Optional<CurrentUserSession> loggedin = sdao.findById(umail);
		
		if(loggedin.isEmpty()) {
			throw new UserException("Please provide a valid key to update a customer");
			
		}
		
		
		
		Optional<User> u = ur.findById(umail);
		
		if(u.isEmpty()) {
			throw new UserException("User not found by this mail");
		}
		
		List<Mail> starred = new ArrayList<>();
		
		
		List<Mail> allMails = u.get().getMails();
		
		
		for(Mail i:allMails) {
			if(i.isStarred()==true) {
				starred.add(i);
			}
		}
		
		return starred;
	}
	



	

}
