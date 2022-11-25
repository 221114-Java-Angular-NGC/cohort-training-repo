package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class MainApp {

	public static Logger logger = LoggerFactory.getLogger(MainApp.class);
	
	public static void main(String[] args) {
		// here is the main entypoint for the app
		//here we will first start the server using Javalin
		//and then from then expose our endpoints

		Javalin app = Javalin.create().start(9000);
		
		//BEFORE & AFTER HANDLERS FOR EACH ENDPOINT CALL
		app.before(ctx -> {
			logger.info("Request at URL " + ctx.url() + " has started.");
		});
		
		app.after(ctx -> {
			logger.info("Request at URL " + ctx.url() + " is now complete.");
		});
		
		//GET METHODS
		app.get("/test", ctx -> {
			//add log message and render test message to browser
			logger.info("Starting HelloJDBC application...");
			ctx.html("Welcome to the HelloJDBC application!");
		});
		
		app.get("/users/{id}", UserController.getUserById);
		
		//POST METHODS
		app.post("/users/register", UserController.register);
		app.post("/users/login", UserController.login);
		
		//PUT METHODS
		app.put("/users/{id}", UserController.update);
		
		//DELETE METHODS
		app.delete("/users/{id}", UserController.delete);
	}

}
