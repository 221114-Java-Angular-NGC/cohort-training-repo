package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Planet;

@Repository("PlanetDao") //To make this into a Spring bean
@Transactional(isolation = Isolation.SERIALIZABLE ,propagation = Propagation.REQUIRED) //if all methods in the class should be transactional 
public class PlanetDAO {

	/**
	 * Class that is responsible for communicating to the database 
	 * 
	 * Will contain basic CRUD methods to allow us to manipulate the database, and provide 
	 * 	abstracted methods to our service layer. 
	 */
	
	/*
	 * Transaction: 
	 * 	Transactions are a set of queries on our database.
	 * 	Transactions should follow ACID: 
	 * 		Atomic - All or nothing 
	 * 		Consistent
	 * 		Isolated 
	 * 		Durable 
	 * 
	 * Databases should have a minimum level of support for transaction, otherwise 
	 * 		we can come across some big issues. 
	 * 
	 * With a transaction, we either commit at then end (committing means that it is visible to you and 
	 * 	to anyone else that is using the database) if everything successful or we rollback if one of the operations fail. 
	 */
	
	@Autowired
	private SessionFactory sesFact;
	
	@Transactional(isolation = Isolation.DEFAULT)
	public void insert(Planet p) {
//		Session ses = sesFact.openSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.save(p);
//		
//		tx.commit();
//		ses.close();
		sesFact.getCurrentSession().save(p);
	}
	
	public List<Planet> selectAll(){

		Session ses = sesFact.openSession();
		
		List<Planet> planetList = ses.createQuery("from Planet", Planet.class).list(); //using HQL 
		
		ses.close();
		
		return planetList;
		
	}
	
}
