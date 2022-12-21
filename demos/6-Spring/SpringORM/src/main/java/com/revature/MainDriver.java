package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Planet;
import com.revature.repo.PlanetDAO;

public class MainDriver {
	
	
	/*
	 * Spring ORM - Object Relational Mapping 
	 * 
	 * SpringORM is another module of Spring, it itself is not an ORM library or framework. 
	 * 
	 * An ORM will automatically convert your database's tables, records and columns into Java Objects. 
	 * 	(so no more ResultSet, and while loops where we manually add them in)
	 * 
	 * SpringORM puppets other ORM libraries - in this case we'll be using Hibernate. 
	 * 	(distinction is important, because Hibernate has it's own set of annotations.)
	 */
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans-annotations.xml");
	
	public static void main(String[] args) {
		
		PlanetDAO pdao = appContext.getBean("PlanetDao",PlanetDAO.class);
		
//		pdao.insert(new Planet(-1, "Mercury"));
//		pdao.insert(new Planet(-1, "Mercury1"));
//		pdao.insert(new Planet(-1, "Mercury2"));
//		pdao.insert(new Planet(-1, "Mercury3"));
		
		System.out.println(pdao.selectAll());
		
		
	}

}
