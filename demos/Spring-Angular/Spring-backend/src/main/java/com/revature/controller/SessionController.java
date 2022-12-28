package com.revature.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Message;
import com.revature.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins={"http://localhost:4200","http://my-angular-frontend-1.s3-website.us-east-2.amazonaws.com"},allowCredentials = "true")
public class SessionController {

	//Set session 
	@GetMapping("/login")
	public Message createSession(HttpSession session) {
		
		//I'm creating a user object - hardcoded for now
		User u = new User();
		u.setUsername("Bob");
		
		//Creating a session and setting "user" to equal "bob"
		session.setAttribute("user", u);
		
		return new Message("You've successfully logged in");
	}
	
	//Check session 
	@GetMapping("/checkAccess")
	public boolean validateSession(HttpSession session) {
		
		boolean access = false;
		if(session.getAttribute("user") != null) {
			
			access = true;
		}
		
		return access; 
		
	}
	
	//Remove session 
	@GetMapping("/logout")
	public void invalidateSession(HttpSession session) {
		session.invalidate();
//		return true;
	}
}
