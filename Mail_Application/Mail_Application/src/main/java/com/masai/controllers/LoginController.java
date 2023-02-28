package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Repositories.SessionDao;
import com.masai.Service.LoginService;
import com.masai.beans.LoginDTO;
import com.masai.exceptions.LoginException;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO dto) throws LoginException{
		
		String asn = ls.logIntoAccount(dto);
		
		return new ResponseEntity<>(asn,HttpStatus.OK);
		
	}
	
	@GetMapping("/logout/{uuid}")
	public ResponseEntity<String> logout(@PathVariable("uuid") String uuid) throws LoginException{
		
		String asn = ls.logOutFromAccount(uuid);
		
		return new ResponseEntity<>(asn,HttpStatus.OK);
	}

}
