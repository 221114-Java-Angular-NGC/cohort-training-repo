package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "user_password", nullable = false)
	private String password;
	
	@Column(name = "user_firstname", nullable = false)
	private String firstName;
	
	@Column(name = "user_lastname", nullable = false)
	private String lastName;
	
	@Column(name = "user_email", nullable = false)
	private String email;
	
	//@OneToMany(fetch = FetchType.EAGER)//TODO: testing Fetch setting vs Cascade setting when deleting users
	@JsonManagedReference
	@OneToMany(mappedBy = "owner", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Blog> blogs = new ArrayList<Blog>();
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String firstName, String lastName, String email,
			List<Blog> blogs) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.blogs = blogs;
	}

	public User(String username, String password, String firstName, String lastName, String email, List<Blog> blogs) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.blogs = blogs;
	}
}
