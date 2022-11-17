package com.revature.service;

import com.revature.exception.InfinityException;

public interface Calculator {
	
	/*
	 * I would like you to practice some TDD for this challenge by adding some unit tests for the
	 * following methods. 
	 * 
	 * It's up to you on how many test cases you want for each method, but I recommend considering
	 * all edge cases - e.g. dividing by zero or passing in a number bigger than double can store. 
	 * 
	 * You don't need to consider testing for exceptions, unless you're feeling brave. 
	 */
	
	
	double add(double x, double y);
	
	double infiniteAdd(double[] doubleArray);
	
	double minus(double x, double y);
	
	boolean isEven(int x);
	
	double divide(double x, double y) throws InfinityException;
	
	
}
