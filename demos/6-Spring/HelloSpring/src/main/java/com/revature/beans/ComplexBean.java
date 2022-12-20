package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * This is an example of a more complex class to instantiate. 
 * This class requires dependencies to be created for it to function 
 * 
 * There are 2 ways I can make this into a fully fleshed out class: 
 * 
 * 	1) I instantiate the class with no args, then provide the dependencies using getters or setters
 *  2) Using the all args constructor 
 */

@Component("ComplexBean")
public class ComplexBean {
	
//	@Autowired //@Autowired tells Sprign to look for a matching bean - this is an example of Field Injection 
	private SimpleBean simpleBean;
	
	private String randomString;
	
	private int bigNumber;
	
	
	
	public void saySomethingMore() {
		simpleBean.saySomething();
		System.out.println("Something else on top!");
		System.out.println(randomString);
		System.out.println(bigNumber);
	}
	
	public ComplexBean() {
		super();
		System.out.println("I'm being isntantiatied empty first!");
		
	}
	
	
//	@Autowired //Checking the constructor argumetns and seeing if there is a matching bean 
	public ComplexBean(SimpleBean simpleBean) {
		super();
		this.simpleBean = simpleBean;
	}



	public ComplexBean(SimpleBean simpleBean, String randomString, int bigNumber) {
		super();
		this.simpleBean = simpleBean;
		this.randomString = randomString;
		this.bigNumber = bigNumber;
	}
	
	
	public SimpleBean getSimpleBean() {
		return simpleBean;
	}
	
	@Autowired
	public void setSimpleBean(SimpleBean simpleBean) {
		this.simpleBean = simpleBean;
	}
	
	public String getRandomString() {
		return randomString;
	}
	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}
	public int getBigNumber() {
		return bigNumber;
	}
	public void setBigNumber(int bigNumber) {
		this.bigNumber = bigNumber;
	}
	
	

}
