package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.SimpleBean;

public class MainDriver {
	
	/*
	 *
	 * What is Spring?
	 * 	Spring is a module based, open source, Java frameowkr. 
	 * 		It provides a lot of support for enterprise level applications, as well as creating boiler plate code for us so that
	 * 		we can focus on business logic. 
	 * 
	 * What is a module?
	 * 	A grouping of libraries that work together to achieve some goals - using reusable abstracted code. 
	 * 	In Spring, modules look like a Maven dependency. 
	 * 
	 * What are modules in Spring?
	 * 	Core, Context, ORM, AOP, WebMVC, Beans, Security, Tests, etc . 
	 * 
	 * 
	 * What is a bean in Spring?
	 * 	Beans in Spring are simply classes that are managed by the Spring Inversion of Control container. 
	 * 
	 * What is an IoC Container in Spring?
	 * 	Is an entity - we'll be using ApplicationContext (but you can older versions like BeanFactory)
	 * 	They will take over control and reduce the boiler plate code in our application as well as providing 
	 * 	nice features like AOP, DI, etc . 
	 * 
	 * 
	 *
	 * 
	 * 
	 */
	
	// Creating a IoC Container.
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans-manual.xml");

	public static void main(String[] args) {
	
		
		//The old way of managing classes and objects
		SimpleBean sb = new SimpleBean();
		
		//the new way - we don't use the "New" keyword anymore
		SimpleBean sb2 = appContext.getBean("MyFirstBean",SimpleBean.class);
		
		sb2.saySomething();

	}

}
