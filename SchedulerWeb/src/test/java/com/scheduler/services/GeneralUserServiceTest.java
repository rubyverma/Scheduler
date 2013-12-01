package com.scheduler.services;

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

	
}
