package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionUtil {

	//this utility class will establish a database connection between this Java program and our SQL ddatabase
	
	//static = non-access modifier = belongs to this class and this class only (aka doesn't exist outside this class)
	public static Logger logger = LoggerFactory.getLogger(JDBCConnectionUtil.class);
	
	//make our connection
	public static Connection getConnection() {
		//1. establish our DB credentials (URL for the host, username, & password)
		//There are two ways to share your creds with your Java program:
		//a. environment variables (recommended)
		//b. hardcoded (BIG NOPE - don't do this please)
		
		//The format:
		//URL: jdbc:postgresql://[host-url]:[port-number}/[database-name(optional)]
		//username & password - same as before
		
		Connection conn = null;
		
		try {
			
			//2. establish our connection's DriverManager to make a new connection based on provided creds
			logger.info(String.format("Making a DB connection with creds: \nURL: %s \nUsername: %s \nPassword: %s", 
					System.getenv("DB_URL"), 
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD")));
			
			conn = DriverManager.getConnection(
					System.getenv("DB_URL"), 
					System.getenv("DB_USERNAME"),
					System.getenv("DB_PASSWORD"));
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return conn;
	}
}
