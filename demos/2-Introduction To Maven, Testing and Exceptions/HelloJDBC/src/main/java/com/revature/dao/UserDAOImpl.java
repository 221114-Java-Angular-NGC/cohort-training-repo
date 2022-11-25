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
		try {
			String sql = "SELECT * FROM users WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			User target = new User();
			
			while(rs.next()) {
				target.setId(rs.getInt("id"));
				target.setUsername(rs.getString("username"));
				target.setPassword(rs.getString("password"));
				target.setFirstName(rs.getString("first_name"));
				target.setLastName(rs.getString("last_name"));
				target.setBirthdate(rs.getDate("birthdate").toLocalDate());
			}
			
			return target;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		try {
			String sql = "SELECT * FROM users WHERE username=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			// by using executeQuery() we get a result set back
			ResultSet rs = pstmt.executeQuery();
			
			//we are creating an instance of our User b/c we will
			// have to return an User
			
			User user = new User();
			
			// this resultset that we get back from our query is what were
			//iterating through in order to make out our User object
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setBirthdate(rs.getDate("birthdate").toLocalDate());
			}
			
			//now that our object's fields have been set, it can be returned that found user 
			return user;
			
		}catch(SQLException sqlEx) {
			logger.error("UserDAOImpl::getByUsername() exception - Message: " + sqlEx.getMessage());
		}
		
		//else if no user is found, return null
		return null;
	}

	@Override
	public boolean update(User user) {
		// here we are going to update the database for a user
		try {
			
			String sql = "UPDATE users SET username=?, password=?, first_name=?, last_name=?, birthdate=? WHERE id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3,user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setDate(5, Date.valueOf(user.getBirthdate()));
			pstmt.setInt(6, user.getId());
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			};
			
		} catch (SQLException sqlEx){
			logger.error("UserDAOImpl - update() " + sqlEx.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		try {

			String sql = "DELETE FROM users WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// it will return false if the first result is an update count
			//			TRUE indicates that query returned a ResultSet object 
			//			FALSE indicate returned an int value or returned nothing.
			// we want it to return False for our delete method because technically we are
			// not returning
			// any result we are just removing it from the db

			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			;

			// we can use Exception even though these methods specifically throw
			// SQLExceptions
			// because Exception is the parent class of all Exceptions
		} catch (Exception e) {
			logger.error("UserDAOImpl - delete() exception thrown! Message: " + e.getMessage());
		}
		return true;
	}

}
