package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.LoginSession;
import com.masai.entity.User;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.repository.LoginSessionDao;
import com.masai.repository.UserRepo;


@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private LoginSessionDao loginDao;
	
	@Override
	public User insertUser(User user) throws UserException {
		User existingCustomer = uRepo.getUserByUsernameAndpassword(user.getMobile(),
				user.getPassword());

		if (existingCustomer != null) {
			throw new UserException("User already exist! Try Login...");
		}

		return uRepo.save(user);
	}

	@Override
	public User updateUser(User user) throws UserException, LoginException {
		Optional<LoginSession> sessionStatusCustomer = loginDao.findById(user.getUserId()); // Login status
		// check

		if (sessionStatusCustomer != null) {
		
		Optional<User> optional = uRepo.findById(user.getUserId());
		
		if (optional.isPresent()) {
		
		loginDao.deleteById(user.getUserId());
		return uRepo.save(user);

	}
	
		throw new UserException("User not found, please register and try again!");
	
	}
		throw new LoginException("Please login to perform this operation!");
	}

	@Override
	public User deleteUser(Integer userId) throws UserException, LoginException {
		LoginSession sessionStatusAdmin = loginDao.findByType("admin"); // Login status check
		Optional<LoginSession> sessionStatusUser = loginDao.findById(userId); // Login status check

		if (sessionStatusAdmin != null || sessionStatusUser.isPresent()) {

			Optional<User> optional = uRepo.findById(userId);

			if (optional.isPresent()) {

				User existingCustomer = optional.get();

				uRepo.delete(existingCustomer);

				loginDao.deleteById(userId);

				return existingCustomer;

			} else {
				throw new UserException("User does not exist!");
			}

		}
		throw new LoginException("Please login to perform this operation!");
	}

	@Override
	public List<User> getAllUsers() throws UserException, LoginException {
		LoginSession sessionStatus = loginDao.findByType("admin"); // Login status check

		if (sessionStatus == null)
			throw new LoginException("Login privileges not available!");

		List<User> User = uRepo.findAll();

		if (User.isEmpty()) {
			throw new UserException("Customer does not exist!");
		}

		return User;
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		
		return uRepo.findById(userId).orElseThrow(()-> new UserException("Invalid User id"));

	}

	

}
