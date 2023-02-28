package com.masai.Service;

import com.masai.entity.LoginDTO;
import com.masai.entity.LoginSession;
import com.masai.Exception.LoginException;

public interface LoginService {
	
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException, Exception;
	
	public String UserLogoutService(String Key) throws LoginException;

}
