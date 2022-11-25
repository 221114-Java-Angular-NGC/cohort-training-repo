package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.models.LoginTemplate;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//since this class is dependent on the service layer, we will need an instance of it here
	private static UserService uServ = new UserServiceImpl();
	
	//here we will need to set up a HTTP handler that deals solely for registration requests
	public static Handler register = ctx -> {
		//here we will be performing actions against our HTTP request
		//1. log event
		logger.info("User is making a registration request...");
		
		//2. get the user info from the request body
		String body = ctx.body();
		
		//here we will convert the body into a User object
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		User target = om.readValue(body, User.class);
		logger.info("New User: " + target);
		
		//3. do service call
		boolean isCreated = uServ.registerUser(target);
		
		//4. render the response
		if(isCreated == true) {
			ctx.html("The new user has been created successfully.");
			ctx.status(HttpStatus.CREATED);
		}else {
			ctx.html("Error during creation. Try again.");
			ctx.status(HttpStatus.NO_CONTENT);
		}
	};
	
	public static Handler login = ctx -> {
		//1. get user info from request body
		String body = ctx.body();
		
		//here we will need to convert the body into a User object
		ObjectMapper om = new ObjectMapper();
		LoginTemplate target = om.readValue(body, LoginTemplate.class);
		
		//2. do service call
		boolean isAuthenicated = uServ.login(target.getUsername(), target.getPassword());
		
		//3. render response
		if(isAuthenicated == true) {
			ctx.html("Successful login. Welcome " + target.getUsername() + "!");
			ctx.status(HttpStatus.OK);
		}else {
			ctx.html("Invalid username and/or password. Please try again.");
			ctx.status(HttpStatus.UNAUTHORIZED);
		}
	};
	
	public static Handler getUserById = ctx -> {
		//to retrieve info from the url, we can use our ContextHandler from Javalin
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		User target = uServ.getUserById(id);
		
		if(target != null && target.getUsername() != null) {
			ctx.json(target);
		}else {
			ctx.html("Error during user search by that id. Try again.");
			ctx.status(HttpStatus.NOT_FOUND);
		}
	};
	
	public static Handler update = ctx -> {
		//1. get user info from request body
		int id = Integer.parseInt(ctx.pathParam("id"));
		String body = ctx.body();
		
		//here we will need to convert the body into a User object
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		User target = om.readValue(body, User.class);
		target.setId(id);
		
		//2. do service call
		boolean isUpdated = uServ.updateUser(target);
		
		//3. render response
		if(isUpdated == true) {
			ctx.html("User ID# "+ id +" : Your user information has been updated successfully.");
			ctx.status(HttpStatus.OK);
		}else {
			ctx.html("Error during update. Try again.");
			ctx.status(HttpStatus.BAD_REQUEST);
		}
	};
	
	public static Handler delete = ctx -> {
		
		//1. get user id from path
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		//2. do service call
		boolean isDeleted = uServ.deleteUser(id);
		
		//3. render response
		
		if(isDeleted == true) {
			ctx.html("User ID# "+ id +" has been removed from the system successfully.");
			ctx.status(HttpStatus.OK);
		}else {
			ctx.html("Error during deletion. Try again.");
			ctx.status(HttpStatus.BAD_REQUEST);
		}
		
	};
}
