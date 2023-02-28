package com.masai.Service;

import com.masai.exceptions.LoginException;
import com.masai.beans.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
