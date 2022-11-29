package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	//since this class depends on the DAO implementation class, we will need an instance of DAO here
	private static UserDAO userDAO;
	
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	public UserServiceImpl(UserDAOImpl ud) {
		this.userDAO = ud;
	}

	@Override
	public boolean registerUser(User user) {
		//1. log event
		logger.info("UserServiceImpl::register() called. Creating new user...");
		//2. get the new id number (do dao method call here)
		int id = userDAO.create(user);
		//3. return true if id exists else return false
		logger.info("Received from DAO. New ID: " + id);
		
		//here I will use a teriary operation for the return statement
		//teriary operation = shorthand conditional statements 
		return (id != 0) ? true : false;
	}

	@Override
	public boolean login(String username, String password) {
		//1. find user that matches username given
		User target = userDAO.getByUsername(username);
		
		//2. check if password/username matches records
		//true = user found, login ok
		if(target.getUsername().equalsIgnoreCase(username) && target.getPassword().equalsIgnoreCase(password)) {
			return true;
		}
		//false = no user found, error in login
		return false;
	}

	@Override
	public User getUserById(int id) {
		logger.info("UserService::getUserById() called. Trying to find user ID# "+ id +"...");
		return userDAO.getById(id);
	}

	@Override
	public boolean updateUser(User user) {
		logger.info("UserService::updateUser() called. Updating user ID# "+ user.getId() +"...");
		return userDAO.update(user);
	}

	@Override
	public boolean deleteUser(int id) {
		logger.info("UserService::deleteUser() called. Deleting user ID# "+ id +"...");
		return userDAO.deleteById(id);
	}

	@Override
	public User getUserByUsername(String ticket) {
		logger.info("UserService::getUserByUsername() called. Trying to find username "+ ticket +"...");
		return userDAO.getByUsername(ticket);
	}

}
