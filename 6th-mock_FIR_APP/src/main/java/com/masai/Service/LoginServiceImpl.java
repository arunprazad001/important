package com.masai.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.LoginDTO;
import com.masai.entity.LoginSession;
import com.masai.entity.User;
import com.masai.Exception.LoginException;
import com.masai.Repo.LoginSessionDao;
import com.masai.Repo.UserRepo;
import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginSessionDao loginDao;
	
	@Autowired
	private UserRepo uRepo;
	
	
	
	@Override
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException ,Exception {
		
		LoginSession existingSession = loginDao.findByMobile(logindata.getMobileNumber());
		
		if(existingSession != null) {
			throw new LoginException("user already logged in");
		}
		
		User existingUser = uRepo.findByMobileAndPassword(logindata.getMobileNumber(), logindata.getPassword());
		
				
		String type = "";
		Integer userId = null;
		
		
		if(existingUser != null) {
			type ="user";
			userId = existingUser.getId();
		}
		
		
		
        
        if(userId == null) throw new Exception("User not registered Yet Please Open a account first");

        LoginSession session = new LoginSession();
        
        session.setLoginTime(LocalDateTime.now());
        session.setType(type);
        session.setUserId(userId);
        session.setMobile(logindata.getMobileNumber());
        String uId = RandomString.make(8);
        session.setUserUniqueId(uId);
		return loginDao.save(session);
        
	}

	@Override
	public String UserLogoutService(String Key) throws LoginException {
		
		LoginSession existingSession =  loginDao.findByUserUniqueId(Key);
		
		if(existingSession != null) {
			
			loginDao.delete(existingSession);
			
			return "You have successfully Log out";
			
		}
		
		throw new LoginException("You have already Logged Out");
		
	}

}
