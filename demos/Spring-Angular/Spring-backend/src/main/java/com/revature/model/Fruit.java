package com.revature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Fruit {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private double calories;
	
	
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
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", calories=" + calories + "]";
	}
	public Fruit(int id, String name, double calories) {
		super();
		this.id = id;
		this.name = name;
		this.calories = calories;
	}
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
