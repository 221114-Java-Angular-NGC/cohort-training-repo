package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

/* For more information about Mockito, please visit these resources:
 * 1. Stubbing & Mocking with Mockito and JUnit: https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit
 * 2. Troubleshooting Mockito (StackOverflow): https://stackoverflow.com/questions/64725199/mockito-unfinishedstubbingexception-thrown-on-a-junit-test-case-which-calls-a-vo?noredirect=1#comment114442210_64725199
 * 3. Mockito JUnit Tutorial (YouTube): https://youtu.be/HsQ9OwKA79s
 * */

class UserServiceTest {
	
	//Unit testing is the process of testing a single unit of code
	//However, testing in some classes requires you to create objects before you can perform operations in your app
	
	//For this reason, this is why we are using the Mockito framework to create fake objects (aka stubs/mocks) and perform expected behaviors based on what you as the developer set for the test
	
	//Class to be tested
	private static UserService uServ;
	
	//Dependent class needed to be mocked by Mockito (will be mocked)
	private static UserDAOImpl userDAO;
	
	private static User temp;
	
	@BeforeAll
	public static void setUp() {
		/*Mockito setup*/
		//1. mock the depending classes
		userDAO = Mockito.mock(UserDAOImpl.class);
		
		//2. inject your service with mocked classes
		uServ = new UserServiceImpl(userDAO);
		
		//3. provide a user stub to test with
		temp = new User(1, "aaknox", "pass", "Azhya", "Knox", LocalDate.of(1994, 1, 18));
	}

	@Test
	@DisplayName("1. Get User by ID - Normal Test") //this annotation will allow you to give your test case a custom, readable name in the TestRunner
	void testGetUserById() {
		//here we need to tell Mockito what it should do if given a specific situation in the program
		//arrange
		when(userDAO.getById(1)).thenReturn(temp);
		
		//act (do the service call)
		User result = uServ.getUserById(1);
		
		//assert & verify that the service method was used once
		//checking if the getById returns a User object that matches temp user
		assertEquals(temp, result);
		
		//verifying that the dao method was used once in the execution of the service call
		verify(userDAO, times(1)).getById(1);
	}
	
	@Test
	@DisplayName("2. Get User by ID - No User ID")
	void testNoUserFoundById() {
		//here we need to tell Mockito what it should do if given a specific situation in the program
		//arrange
		when(userDAO.getById(0)).thenReturn(null);
		
		//act (do the service call)
		User result = uServ.getUserById(0);
		
		//assert & verify that the service method was used once
		//checking if the getById returns a User object that matches temp user
		assertEquals(null, result);
		
		//verifying that the dao method was used once in the execution of the service call
		verify(userDAO, times(1)).getById(0);
	}

	
}
