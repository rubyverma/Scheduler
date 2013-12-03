package com.scheduler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.GeneralUser;

public class GeneralUserServiceTest extends BaseTest{

	@Autowired(required=true)
	private GeneralUserService generalUserService;
	
	@Test
	public void testGeneralUserRegistration()
	{
		Date date= new Date(1985,12,12);
		
		GeneralUser generaluser= new GeneralUser();
		generaluser.setClientId(1);
		generaluser.setUsername("testUser");
		generaluser.setPassword("testPassword");
		generaluser.setFirstName("testFirstName");
		generaluser.setLastName("testLastName");
		generaluser.setEmail("techrockers@yahoo.co.in");
		//generaluser.setDob(date);
		generaluser.setAddress("test Address");
		generaluser.setGender("Male");
		generaluser.setTocken("123456");
		generaluser.setGcmRegId("test GCM ID");
		int testResult=generalUserService.saveUser(generaluser);
		
		assertTrue("Failed to Register General User",testResult==1);
	}

	@Test
	public void testGeneralUserVerification()
	{
		int testVerify=0;
			int userId= generalUserService.getLastUserId();
			String gettoken= generalUserService.getUserToken(userId);
			if(gettoken.equals("123456"))
			{
			testVerify=generalUserService.verifyUser(userId);
		
			}
			assertTrue("Failed to Verify General User",testVerify==1);
	}
	
	@Test
	public void testUpdateGeneralUser() {

		GeneralUser newGeneralUser = new GeneralUser();
		newGeneralUser.setClientId(1);
		newGeneralUser.setUsername("General user username test");
		newGeneralUser.setFirstName("General user first name test");
		newGeneralUser.setLastName("General user last name test");
		newGeneralUser.setEmail("General user email test");
		newGeneralUser.setDob(Date.valueOf("2000-12-12"));
		newGeneralUser.setAddress("General user address test");
		newGeneralUser.setGender("Male");
		newGeneralUser.setPassword("aaa");
		newGeneralUser.setTocken("token");
		generalUserService.saveUser(newGeneralUser);
		int userId = 1;
		
		GeneralUser updateGeneralUser = new GeneralUser();
		updateGeneralUser.setUserId(userId);
		updateGeneralUser.setUsername("General user update username test");
		updateGeneralUser.setFirstName("General user update first name test");
		updateGeneralUser.setLastName("General user update last name test");
		updateGeneralUser.setEmail("General user update email test");
		updateGeneralUser.setAddress("General user update address test");
		updateGeneralUser.setGender("Female");
		int actualUpdatedStatus = generalUserService.updateUser(updateGeneralUser);
		int expectedUpdatedStatus = 1;
		assertEquals(actualUpdatedStatus, expectedUpdatedStatus);

		GeneralUser generalUserFromDB = generalUserService.getGeneralUser(1);
		String actualUsername = generalUserFromDB.getUsername();
		String expectedUsername = "General user update username test";
		String actualFirstName = generalUserFromDB.getFirstName();
		String expectedFirstName = "General user update first name test";
		String actualLastName = generalUserFromDB.getLastName();
		String expectedLastName = "General user update last name test";
		String actualEmail = generalUserFromDB.getEmail();
		String expectedEmail = "General user update email test";
		String actualAddress = generalUserFromDB.getAddress();
		String expectedAddress = "General user update address test";
		String actualGender = generalUserFromDB.getGender();
		String expectedGender = "Female";
		
		assertEquals(actualUsername, expectedUsername);
		assertEquals(actualFirstName, expectedFirstName);
		assertEquals(actualLastName, expectedLastName);
		assertEquals(actualEmail, expectedEmail);
		assertEquals(actualAddress, expectedAddress);
		assertEquals(actualGender, expectedGender);
	}
	
	@Test
	public void testUpdatePassword() {

		GeneralUser newGeneralUser = new GeneralUser();
		newGeneralUser.setClientId(1);
		newGeneralUser.setUsername("General user username test");
		newGeneralUser.setFirstName("General user first name test");
		newGeneralUser.setLastName("General user last name test");
		newGeneralUser.setEmail("General user email test");
		newGeneralUser.setDob(Date.valueOf("2000-12-12"));
		newGeneralUser.setAddress("General user address test");
		newGeneralUser.setGender("Male");
		newGeneralUser.setPassword("password");
		newGeneralUser.setTocken("token");
		generalUserService.saveUser(newGeneralUser);
		int userId = 1;
		
		GeneralUser updateGeneralUser = newGeneralUser;
		updateGeneralUser.setUserId(userId);
		updateGeneralUser.setPassword("updated password");
		int actualUpdatedStatus = generalUserService.updatePassword(updateGeneralUser);
		int expectedUpdatedStatus = 1;
		assertEquals(actualUpdatedStatus, expectedUpdatedStatus);

		GeneralUser generalUserFromDB = generalUserService.getGeneralUser(1);
		String actualPassword = generalUserFromDB.getPassword();
		String expectedPassword = "updated password";
		assertEquals(actualPassword, expectedPassword);

	}	
}
