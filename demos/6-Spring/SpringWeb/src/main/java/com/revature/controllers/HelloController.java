package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //stereotype 
//@RequestMapping(value="/api")
@CrossOrigin(origins="*") //resolve any CORS issues 
public class HelloController {
	
	@RequestMapping(value="/hello") //localhost:<port>/api/hello - defaults to a GET request 
	public @ResponseBody String sayHello() {  //By default, a Controller will not assume you're sending a response body
		return "ello! There";
	}
	
//	@RequestMapping(value="/hello/page")
//	public String anotherHello() {
//		return "index";
//	}

}
