package com.revature.beans;

import org.springframework.stereotype.Component;

/*
 * Beans in Spring are simply classes that are managed by the Spring Inversion of Control container. 
 * 
 * So as developers, we are no longer responsible for creating or managing some Java classes. 
 * 
 * We do this, to reduce the amount of boiler plate code! 
 */

// Using annotations based configuration 
// We provide "stereotypes" to classes, to tell Spring what the nature of this class is 

/*
 * Service, Util packages, Controller, Dao/Repository
 */

//@Service 
//@Controller
//@RestController 
//@Repository
@Component //A base stereotype, used when a class does not fit a nice mold 
public class SimpleBean {
	
	public SimpleBean() {
		System.out.println("I now exist!");
	}
	
	
	public void saySomething() {
		System.out.println("Hello!");
	}

}
