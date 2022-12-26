package com.revature.service;

import org.springframework.stereotype.Component;

@Component
public class FruitService {
	
	public void randomMethod() {
		
		System.out.println("inside random");
		
	}
	
	public Integer intMethod(int i) {
		System.out.println("inside int method");
		return 0;
	}
	
	public Double doubleMethod(double i, int j) {
		System.out.println("inside double method");
		return 0.0;
	}

}
