package com.masai.service;

import com.masai.entity.LoginDTO;
import com.masai.entity.LoginSession;
import com.masai.exception.LoginException;

public interface LoginService {
	
	public LoginSession userLoginService(LoginDTO logindata) throws LoginException, Exception;
	
	public String UserLogoutService(String Key) throws LoginException;

}
