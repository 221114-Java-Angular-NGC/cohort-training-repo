package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean login(String username, String password) {
		User target = getUserByUsername(username);
		System.out.println("Found user: " + target);
		return (target.getUsername().equals(username) && target.getPassword().equals(password)) ? true : false;
	}

	@Override
	public boolean logout(String authCookieToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		int pk = userRepo.save(user).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		User target = userRepo.findByUsernameStartsWith(username);
		System.out.println("Found user: " + target);
		return target;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
