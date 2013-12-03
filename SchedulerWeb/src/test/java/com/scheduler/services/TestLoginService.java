package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.jdbc.BadSqlGrammarException;

import com.scheduler.BaseTest;
import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;
import com.scheduler.BaseTest;

public class TestLoginService extends BaseTest {
	
	    @Autowired(required = true)
		private ClientService clientService;
	    
	    @Autowired(required = true)
	    private OfficialUserService officialUserService;
	    
	    @Autowired(required = true)
	    private GeneralUserService generalUserService;

	    @Test
		public void testClientLogin()
		{
			Client client= new Client();
			client.setPassword("test");
			client.setEmail("techrockers@yahoo.co.in");
			Client testResult= clientService.authenticate(client);
			assertTrue("Failed to authenticate Client",testResult==null);
			
		}
	    
	    @Test
		public void testOfficialLogin()
		{
			OfficialUser officialUser= new OfficialUser();
			officialUser.setPassword("test");
			officialUser.setEmail("techrockers@yahoo.co.in");
			OfficialUser testResult= officialUserService.authenticate(officialUser);
			assertTrue("Failed to authenticate officialUser",testResult==null);
			
		}
	    
	    @Test
		public void testGeneralLogin()
		{
			GeneralUser generalUser= new GeneralUser();
			generalUser.setPassword("test");
			generalUser.setEmail("techrockers@yahoo.co.in");
			GeneralUser testResult= generalUserService.authenticate(generalUser);
			assertTrue("Failed to authenticate generalUser",testResult==null);
			
		}

}
