package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Saiyan;
import com.revature.service.SaiyanService;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

public class SaiyanController {

	private static SaiyanService sv = new SaiyanService();

	public static void main(String[] args) {

		/*
		 * Javalin is considered lightweight framework for quickly building RESTful
		 * APIs. It comes with an embedded Jetty server and is an abstraction over an
		 * older technology called servlets.
		 */

		// start my server on port 8080
		Javalin app = Javalin.create().start(8080);

		/*
		 * As a matter of abstraction, sometimes we wish to perform a task before an
		 * HTTP Request makes it to its destination. In order to avoid mixing this logic
		 * into all of our endpoint logic, we can use an interceptor.
		 */

		// lambda expressions = shortened execution of functional methods that uses
		// arrow syntax
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

		// make an endpoint to send info about our new saiyan
		app.get("/add-saiyan", ctx -> {
			Saiyan goku = new Saiyan(1, "Goku", 9001);

			try {
				System.out.println(sv.addNewSaiyan(goku));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		});

		// make a post endpoint to login
		app.post("/login", ctx -> {

			/*
			 * This resource takes in user credentials and authenticates the client if the
			 * credentials are correct. If the user credentials are correct, I will grant
			 * them a session. Some of my options for session handling include:
			 * 
			 * 1) Cookies: A cookie is actually stored on the client machine as a file.
			 * Every single time a client makes a request to a domain, the cookies
			 * associated with that domain come with the request. We can create a cookie on
			 * the server side and send it to the client. Note also that a cookie is a
			 * key-value pair.
			 * 
			 * 2) HttpSession: Technically, HttpSessions in Java do store a cookie on the
			 * client machine. That said, they also store information on the server side.
			 * This information is an ID that is associated with a session. Every time the
			 * client sends its cookies, the JSessionID is checked against the id for the
			 * one of the cookies. This method of session handling is easy, but if you use
			 * it, your API is not truly RESTful in that you're storing information about
			 * the session on the server itself.
			 * 
			 * 3) JSON web tokens (JWTs): A JSON web token is another option for handling
			 * sessions. A JSON web token is a more RESTful option as it doesn't require
			 * that you store session information on the server, which makes your
			 * application stateless. JSON web tokens are passed to the server from the
			 * client on every HTTP request. The token is initially given to the client by
			 * the server. The tokens themselves are actually encrypted and usually signed
			 * by the server. If the token is at all tampered with, most libraries will warn
			 * you so that you can choose not to acknowledge the token. Note that this
			 * requires a 3rd party library, and there MANY providers.
			 * 
			 * NOTE: For this example, I will assume that the correct credentials must be
			 * "azhya" for the username and "pass" for the password.
			 */
			
			//this is how you get the content from the HTTP request (body)
			String body = ctx.body();
			System.out.println(body);
			
			//now you will use Jackson Databind to marshal our JSON data into an actual Java object
			//1. create an objectmapper
			ObjectMapper om = new ObjectMapper();
			
			//2. convert JSON to Java Object (deserializing into an Saiyan object)
			Saiyan hero = om.readValue(body, Saiyan.class);
			
			//3. use object to perform service call
			try {
				int id = sv.addNewSaiyan(hero);
				System.out.println("New id num: " + id);
				if (id != 0) {
					//set the hero id number on the object to equal the new id number
					System.out.println("Before: " + hero.getId());
					hero.setId(id);
					System.out.println("After: " + hero.getId());
					//4. render the HTTP response
					System.out.println("Congrats, Saiyan " + hero.getName() + " has been created successfully.");
					ctx.json(hero);
					ctx.status(HttpStatus.CREATED);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				//4. render the HTTP response
				String message = "Error during creation. Try again.";
				ctx.json(message);
				ctx.status(HttpStatus.CONFLICT);
			}
			
		});
	}
}