package com.revature.exception;

public class InfinityException extends Exception {

	public InfinityException() {
		super("You can't do that!!!");
	}
	
	public InfinityException(String message) {
		super(message);
	}
}
