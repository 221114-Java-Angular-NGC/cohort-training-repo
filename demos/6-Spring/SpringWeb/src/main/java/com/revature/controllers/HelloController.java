package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.models.Fruit;

@Controller //stereotype 
//@RequestMapping(value="/api")
@CrossOrigin(origins="*") //resolve any CORS issues 
public class HelloController {
	
	/*
	 * Spring has support for server side rendering, where all the views are created and managed 
	 * 	by the backend services. 
	 */
	
	@RequestMapping(value="/hello") //localhost:<port>/api/hello - defaults to a GET request 
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public @ResponseBody String sayHello() {  //By default, a Controller will not assume you're sending a response body
		
		Fruit f = new Fruit(1,"Tomatoe",10);
		
		return "ello! There: We have this fruit in our stocks: " + f.toString();
	}
	
	@RequestMapping(value="/hello/page")
	public String anotherHello() {
		return "/index.html"; //forwarding - moving it to the location of the html file
	}
	
	//Indirect Responses 
	// Forwarding and Redirecting 
	// Forwarding is where you internally send the request to another resource (controller, view, etc .) 
	// 	without the client being aware. 
	
	// Redirecting is when you tell the client to send another request to another endpoint. Big difference is
	// that the client is aware of the new resource location. 
	
	@RequestMapping(value="/forward")
	public String forwardResponse() { //forwarding only works within the domain. 	
//		return "forward:/hello";
		return "forward:/api/fruit/2";
	}
	
	@RequestMapping(value="/redirect")
	public String redirectResponse() { //request to the server, response from the server, request to the new endpoint, 
										//response from the new endpoint 
		return "redirect:/hello";
	}
	
	@RequestMapping(value="/external/redirect")
	public RedirectView externalRedirect() {
		RedirectView rView = new RedirectView();
		rView.setUrl("https://www.google.com");
		return rView;
	}
	
	


}
