package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Start using Hibernate annotations. 

@Entity //Tells Hibernate that this is class that will be converted into records 
@Table(name="planet_table")
public class Planet {
	
	@Id //this column will be a primary key 
	@Column(name="planet_id")
	@GeneratedValue(strategy = GenerationType.AUTO) //will automatically generate id values for me 
	private int id;
	
	@Column(name="planet_name", unique = true,nullable = false)
	private String name;
	
	

	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planet(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
