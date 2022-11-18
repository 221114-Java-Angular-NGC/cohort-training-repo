package com.revature.controller;

import com.revature.models.Saiyan;
import com.revature.service.SaiyanService;

import io.javalin.Javalin;

public class SaiyanController {
	
	
	private static SaiyanService sv = new SaiyanService();
	
	public static void main(String[] args) {
		
		/*
		 * Javalin is considered lightweight framework for quickly building RESTful
		 * APIs. It comes with an embedded Jetty server and is an abstraction over an
		 * older technology called servlets.
		 */
		
		//start my server on port 8080
		Javalin app = Javalin.create().start(8080);
		
		/*
		 * As a matter of abstraction, sometimes we wish to perform a task before an
		 * HTTP Request makes it to its destination. In order to avoid mixing this logic
		 * into all of our endpoint logic, we can use an interceptor.
		 */
		
		//lambda expressions = shortened execution of functional methods that uses arrow syntax
		app.before(ctx -> {
			System.out.println("This happens before HTTP request");
		});
		
		/*
		 * Javalin uses lambda expressions heavily. It primarily uses the Handler
		 * interface. This interface has a single abstract method called handle that
		 * takes a Context object and has a void return type.
		 * 
		 * As a note, the Context is an abstraction over servlet internals that allow us
		 * to access and manipulate the HTTP request and HTTP response as Java objects.
		 */
		
		//make an endpoint to send info about our new saiyan
		app.get("/add-saiyan", ctx -> {
			Saiyan goku = new Saiyan(1, "Goku", 9001L);
			
			try {
				System.out.println(sv.addNewSaiyan(goku));
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		});
	}
}
