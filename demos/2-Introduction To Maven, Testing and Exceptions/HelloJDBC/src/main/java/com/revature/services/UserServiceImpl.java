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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserById(int id) {
		return userDAO.getById(id);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
