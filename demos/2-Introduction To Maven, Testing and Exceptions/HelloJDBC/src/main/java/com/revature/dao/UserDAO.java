package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	//Here we are going to make our CRUD methods
	//CRUD = create, read, update, delete
	
	int create(User user);
	
	User getById(int id);
	
	User getByUsername(String username);
	
	boolean update(User user);
	
	boolean deleteById(int id);

}
