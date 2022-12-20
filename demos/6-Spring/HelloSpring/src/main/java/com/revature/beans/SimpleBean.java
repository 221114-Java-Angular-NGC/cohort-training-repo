package com.revature.beans;

/*
 * Beans in Spring are simply classes that are managed by the Spring Inversion of Control container. 
 * 
 * So as developers, we are no longer responsible for creating or managing some Java classes. 
 * 
 * We do this, to reduce the amount of boiler plate code! 
 */

public class SimpleBean {
	
	public void saySomething() {
		System.out.println("Hello!");
	}

}
