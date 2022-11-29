package com.revature.services;

import com.revature.models.User;

public interface UserService {
	//here we will provide the method calls that will handle our business logic for our app
	//To do so, the service layer will communicate and pass the info from the dao layer to our controller layer
	//These layers of abstraction are considered good practices for decoupling your application
	
	public boolean registerUser(User user);
	
	public boolean login(String username, String password);
	
	public User getUserById(int id);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(int id);

	public User getUserByUsername(String ticket);

}
