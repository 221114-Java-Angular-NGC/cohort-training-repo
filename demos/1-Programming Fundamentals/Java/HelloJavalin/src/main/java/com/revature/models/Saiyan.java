package com.revature.models;

//making a java bean!!
public class Saiyan {
	
	private int id;
	private String name;
	private long powerLevel;
	
	public Saiyan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Saiyan(int id, String name, long powerLevel) {
		super();
		this.id = id;
		this.name = name;
		this.powerLevel = powerLevel;
	}

	public Saiyan(String name, long powerLevel) {
		super();
		this.name = name;
		this.powerLevel = powerLevel;
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

	public long getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(long powerLevel) {
		this.powerLevel = powerLevel;
	}

	@Override
	public String toString() {
		return "Saiyan [id=" + id + ", name=" + name + ", powerLevel=" + powerLevel + "]";
	}
}
