package com.revature.models;

import java.time.LocalDate;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok allows you to have boilerplate code for your models based on annotations from this library
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String firstName, String lastName, LocalDate birthdate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
	public User(String username, String password, String firstName, String lastName, LocalDate birthdate) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
}
