package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.entity.User;
import com.masai.service.UserService;




@RestController
public class UserController {

	
	@Autowired
	private UserService uService;
	
	@PostMapping("/useradd")
	public ResponseEntity<User>addSeedHandler(@RequestBody User user) throws UserException{
		User savedUser=uService.Adduser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/userdelete")
	public ResponseEntity<User>deleteSeedHandler(@RequestBody User user) throws UserException{
		User deleteduser=uService.DeleteUser(user);
		return new ResponseEntity<User>(deleteduser,HttpStatus.OK);
	}
	
	@GetMapping("/userid/{userId}")
	public ResponseEntity<User>viewSeedByIdHandler(@PathVariable("userId") Integer userId) throws UserException{
		User currentuser=uService.viewUserbyId(userId);
		return new ResponseEntity<User>(currentuser,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>>viewAllSeedsHandler() throws UserException{
		List<User>users=uService.viewAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
}
