package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Client;

public class TestResetPasswordService extends BaseTest {
	 @Autowired(required = true)
		private ClientService clientService;
	    
	    @Autowired(required = true)
	    private OfficialUserService officialUserService;
	    
	    @Autowired(required = true)
	    private GeneralUserService generalUserService;
	    
	    @Test
		public void testClientResetPassword()
		{
	    	Random randomGenerator = new Random();
	    	String email = "techrockers@yahoo.co.in";
			String myPassword = Integer.toString(randomGenerator.nextInt(20000));
			int passwordUpdate = clientService.resetPassword(email, myPassword);
			assertTrue("Failed to reset password for client",passwordUpdate==0);
			
		}
	    
	    @Test
		public void testGeneralUserResetPassword()
		{
	    	Random randomGenerator = new Random();
	    	String email = "techrockers@yahoo.co.in";
			String myPassword = Integer.toString(randomGenerator.nextInt(20000));
			int passwordUpdate = generalUserService.resetPassword(email, myPassword);
			assertTrue("Failed to reset password for general user",passwordUpdate==0);
			
		}
	    
	    @Test
		public void testOfficialUserResetPassword()
		{
	    	Random randomGenerator = new Random();
	    	String email = "techrockers@yahoo.co.in";
			String myPassword = Integer.toString(randomGenerator.nextInt(20000));
			int passwordUpdate = officialUserService.resetPassword(email, myPassword);
			assertTrue("Failed to reset password for official user",passwordUpdate==0);
			
		}
}
