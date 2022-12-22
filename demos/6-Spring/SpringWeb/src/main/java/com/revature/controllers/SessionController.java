package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

	
	/*
	 * Spring can inject other objects into our controller methods if it sees that it has to. 
	 * e.g. HttpSession, HttptServletRequest, HttpServletResponse
	 */
	
	//3 Methods, to create a session, to check a session and to invalidate a session 
	
	@PostMapping(value="login")
	public String login(HttpServletRequest req, @RequestParam("name") String name) {
		
		HttpSession session = req.getSession(true); //create a session, or return an existing one 
		
		session.setAttribute("Access", true);
		session.setAttribute("LoggedName", name);
		
		return "Success";
	}
	
	@GetMapping(value="validate")
	public String getInfo(HttpSession session) {
		
		String name = (String) session.getAttribute("LoggedName");
		Boolean access = (Boolean) session.getAttribute("Access");
		
		if(name != null) {
			if(name.equals("Bob")) {
				return "Your name is Bob";
			}else {
				return "Your name is not Bob";
			}
		}else {
			return "Get a valid session first";
		}
		
		
		
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "Au revior";
	}
	
}
