package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Planet;

@Repository("PlanetDao") //To make this into a Spring bean
public class PlanetDAO {

	/**
	 * Class that is responsible for communicating to the database 
	 * 
	 * Will contain basic CRUD methods to allow us to manipulate the database, and provide 
	 * 	abstracted methods to our service layer. 
	 */
	
	@Autowired
	private SessionFactory sesFact;
	
	
	public void insert(Planet p) {
		Session ses = sesFact.openSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(p);
		
		tx.commit();
		ses.close();
	}
	
	public List<Planet> selectAll(){

		Session ses = sesFact.openSession();
		
		List<Planet> planetList = ses.createQuery("from Planet", Planet.class).list(); //using HQL 
		
		ses.close();
		
		return planetList;
		
	}
	
}
