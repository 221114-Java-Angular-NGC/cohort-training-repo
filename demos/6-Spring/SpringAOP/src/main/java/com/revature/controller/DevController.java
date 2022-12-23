package com.revature.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Profile("dev") //Spring will only instantiate this bean, when a profile has been set to active in the application configuration file
@Profile("!prod") //Spring will instantiate this bean, as long as prod profile is not active. 
public class DevController {

	@GetMapping(value = {"/hello","/ello"})
	public String sayHello() {
		return "Hello";
	}
}
