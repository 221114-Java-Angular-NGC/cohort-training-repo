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
import jakarta.servlet.http.Cookie;

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
		//checking to see if the user does exist in the system
		if(isAuthenicated == true) {
			//if true - creating a HTTP cookie for our logged in user and sending that cookie in the HTTP response
			ctx.html("Successful login. Welcome " + target.getUsername() + "!");
			
			//authorize user
			//using Javalin's CookieSet to save our session cookie for later authorization for admin-level methods (ex. only allow deletions if user is manager)
			ctx.cookieStore().set("Auth-Cookie", target.getUsername() + "-56797-woof");
			Cookie auth = new Cookie("Auth-Cookie", target.getUsername() + "woof9000bark");
			ctx.res().addCookie(auth); //adds the HTTP cookie to the response header
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
		//a. get our HTTP cookie from the request header
		String ticket = ctx.req().getHeader("Auth-Cookie").replaceAll("woof9000bark", "");
		logger.info("Authentication cookie: " + ticket);
		
		//b. get the logged in user info
		User target = uServ.getUserByUsername(ticket);
		logger.info("Based on cookie, this is your logged in user: " + target);
		
		//3. render response
		//if current user matches this given admin username, then do the deletion
		try {
			
			if(target.getUsername().equalsIgnoreCase("aaknox")) {
				boolean isDeleted = uServ.deleteUser(id);
				
				if(isDeleted == true) {
					ctx.html("User ID# "+ id +" has been removed from the system successfully.");
					ctx.status(HttpStatus.OK);
				}else {
					ctx.html("Error during deletion. Try again.");
					ctx.status(HttpStatus.BAD_REQUEST);
				}
			}
		}catch (NullPointerException e){
			//this is how you can handle your custom exceptions gracefully
			//if not me, then send a NotAuthorized status code back in the Http response
			ctx.html("Sorry, this user is not authorized to perform this operation. Error: " + e.getMessage());
			ctx.status(HttpStatus.UNAUTHORIZED);
		}
		
	};
}
