package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.User;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.service.LoginService;
import com.masai.service.UserServices;




@RestController
@RequestMapping("/masaifir")
public class UserController {

	@Autowired
	private UserServices uService;

	@Autowired
	private LoginService lService;

	

//### Add New User ###
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user)
			throws UserException {

		User newCustomer = uService.insertUser(user);

		return new ResponseEntity<User>(newCustomer, HttpStatus.CREATED);
	}

//### Update Existing User ###
	@PutMapping("/user/update")
	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user)
			throws UserException, LoginException {

		User updatedUser = uService.updateUser(user);

		return new ResponseEntity<User>(updatedUser, HttpStatus.CREATED);
	}


//### Delete Account ###
	@DeleteMapping("/user/delete")
	public ResponseEntity<User> deleteAccountHandler(@RequestParam("customerId") Integer userId)
			throws UserException, LoginException {

		User deletedUser = uService.deleteUser(userId);

		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);

	}

//### Get All User in a List ###
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException, LoginException {

		List<User> users = uService.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

//### Get single user using userId
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("userId") Integer userId)
			throws UserException, LoginException {

		User fetchedUser = uService.getUserById(userId);

		return new ResponseEntity<User>(fetchedUser, HttpStatus.OK);
	}




}
