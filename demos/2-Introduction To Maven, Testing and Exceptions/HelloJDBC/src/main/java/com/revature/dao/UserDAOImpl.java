package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.util.JDBCConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	Connection conn;
	
	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	//here we are establishing that connection so JDBC can start preparing statements
	public UserDAOImpl() {
		conn = JDBCConnectionUtil.getConnection();
	}
	

	@Override
	public int create(User user) {
		// this will be how we insert new users into db
		try {
			//1. prepare our SQL statement
			//we are using ? as a placeholder for the values we will set in our preparedstatement
			//this is used to prevent SQL injection (aka your users having the ability to mess up your code with their own data)
			String sql = "INSERT INTO users (username, password, first_name, last_name, birthdate) VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//now we are filling in the ?
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setDate(5, Date.valueOf(user.getBirthdate()));
			
			//note that when we are inserting, we will get back our new ID number from the ResultSet
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			//this result set works off of a cursor that starts before the first record
			rs.next();
			
			logger.info("UserDAOImpl - create() - new user id is " + rs.getInt(1));
			return rs.getInt("id");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//else if no user creation done, return 0
		return 0;
	}

	@Override
	public User getById(int id) {
		
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
