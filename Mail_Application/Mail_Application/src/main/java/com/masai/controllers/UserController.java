package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.UserService;
import com.masai.beans.Mail;
import com.masai.beans.User;



@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User user1 = us.createCustomer(user);
		
		return new ResponseEntity<>(user1,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @RequestParam(required = false) String key ){
		
		User user1 = us.updateCustomer(user, key);
		
		return new ResponseEntity<>(user1,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/allMails/{key}")
	public ResponseEntity<List<Mail>> checkAllMails(@PathVariable String key  ,String mail){
		
		List<Mail> allMails = us.checkAllMails(mail,key);
		
		return new ResponseEntity<>(allMails,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/starredMails/{key}")
	public ResponseEntity<List<Mail>> checkAllstarredMails(@PathVariable String key, String mail){
		
		List<Mail> allMails = us.checkAllStarredMails(mail,key);
		
		return new ResponseEntity<>(allMails,HttpStatus.OK);
		
	}
	
	

}
