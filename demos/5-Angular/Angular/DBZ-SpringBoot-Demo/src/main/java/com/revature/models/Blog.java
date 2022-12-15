package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "blogs")
@Data
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int id;
	
	@Column(name = "blog_title")
	private String title;
	
	@Column(name = "blog_subject")
	private String subject;
	
	@Column(name = "blog_body")
	private String body;
	
	@Column(name = "blog_categories") //NOTE: this string is delimited by commas for each category 
	private String categories;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name = "blog_user_id")
	private User owner;
	
	public Blog() {
		super();
	}

	public Blog(int id, String title, String subject, String body, String categories, User owner) {
		super();
		this.id = id;
		this.title = title;
		this.subject = subject;
		this.body = body;
		this.categories = categories;
		this.owner = owner;
	}

	public Blog(String title, String subject, String body, String categories, User owner) {
		super();
		this.title = title;
		this.subject = subject;
		this.body = body;
		this.categories = categories;
		this.owner = owner;
	}
}
