package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
}
