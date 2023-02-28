package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repositories.SessionDao;
import com.masai.Repositories.UserRepo;
import com.masai.beans.CurrentUserSession;
import com.masai.beans.LoginDTO;
import com.masai.beans.User;
import com.masai.exceptions.LoginException;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImple implements LoginService {
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private SessionDao cur;
	
	

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		Optional<User> u = ur.findById(dto.getEmail());
		
		if(u.isEmpty()) {
			throw new LoginException("Email is not registered");
		}
		
		 Optional<CurrentUserSession> u2 =  cur.findById(dto.getEmail());
		 
		 if(u2.isPresent()) {
			 throw new LoginException("User is already logged in");
		 }
		 else {
				String key= RandomString.make(6);
				
				
				
				CurrentUserSession currentUserSession = new CurrentUserSession(u.get().getEmail(),key,LocalDateTime.now());
				
				
				
				cur.save(currentUserSession);

				return "Login Successfull";
		 }
		
		
	}

	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = cur.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		cur.delete(validCustomerSession);

		return "Logged Out !";

	}
	
	

}
