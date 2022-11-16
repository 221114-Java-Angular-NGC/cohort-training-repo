package com.example.interfaces;

public interface Truck {
	
	/*
	 * Interfaces in Java can be thought of as contracts, they define what methods 
	 * 	any child class is going to have fufil. 
	 * 
	 * In fact, interfaces a form of abstraction that we get in Java. 
	 */

	
	double accelerate();
	boolean brake();
	void steer();
	void pickUpStuff();
}
