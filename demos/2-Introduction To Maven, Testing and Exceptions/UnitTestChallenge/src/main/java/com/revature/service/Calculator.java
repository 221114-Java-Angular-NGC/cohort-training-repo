package com.revature.service;

import com.revature.exception.InfinityException;

public interface Calculator {
	
	
	double add(double x, double y);
	
	double infiniteAdd(double[] doubleArray);
	
	double minus(double x, double y);
	
	boolean isEven(int x);
	
	double divide(double x, double y) throws InfinityException;
	
	
}
