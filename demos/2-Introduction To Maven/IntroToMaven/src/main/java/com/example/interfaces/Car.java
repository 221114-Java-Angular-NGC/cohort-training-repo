package com.example.interfaces;

public interface Car {
	
	//Interfaces can't have any concrete methods 
	// Every method in Interfaces are abstract - i.e. no method body 
	// the "abstract" keyword is implicit, so you don't need to add it.
	// the "public" keyword is also implicit
	
//	public abstract void accelerate();
	double accelerate();
	void drift();
	
	//Interfaces don't have constructors, you can't directly create an interface. 
	//You need a child class to create an interface
	
	//Interface attributes are by default, public, static and final 
	// public is an access modifier
	// static means that it belongs to the interface, not the instance of the interface. 
	// final: in the context of a variable, it means it cannot be reassigned. 
	
//	public static final double GRAVITY = 9.81;
	double GRAVITY = 9.81;
	String name = "example";

}
