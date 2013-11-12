package com.scheduler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.User;

public class TestUserService extends BaseTest {

	@Autowired(required = true)
	private UserService userService;

	@Test
	public void testMultiply() {
		// Save the user First
		/*
		userService.saveUser(ddg.createUser());

		assertEquals("10 x 5 must be 50", 50, 10 * 5);
		*/
	}

	@Test
	public void testGetUsers() {

		// Save the user First
		
		final User u = ddg.createUser();
		userService.saveUser(u);
		
		// Check that user is fetched from database
		List<User> users = userService.findAllUsers();		assertNotNull(users);
		assertTrue(users.size() > 0);

		// Check that user data is same
		assertTrue("Data does not match", users.get(0).getId()
				.equals(u.getId()));
		assertTrue("Data does not match",
				users.get(0).getEmail().equals(u.getEmail()));
		assertTrue("Data does not match",
				users.get(0).getFirstname().equals(u.getFirstname()));
		assertTrue("Data does not match",
				users.get(0).getLastname().equals(u.getLastname()));

		// delete user after test to begin another test
		userService.deleteUser(u.getId());

	}
	
	@Test
	public void testInsertUser() {
		//Save the user First
		final User u = ddg.createUser();		
		int i = userService.saveUser(u);
		
		assertNotNull(i);
		assertTrue("User not inseted", i != 0);
		
		//Check that user it exists in database
		List<User> users = userService.findAllUsers();
	    assertNotNull(users);
	    assertTrue(users.size() > 0);
	    
	    //No need to check the data in this case
	    //delete user after test to begin another test
	    userService.deleteUser(u.getId());
	}	
}
