package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;

public class VerifyClientService extends BaseTest{
	
	@Autowired(required = true)
	private ClientService clientService;
	
	@Test
	public void TestClientVerification()
	{
		int client_id = 4;
		String tokenFromDB = clientService.getClientToken(client_id);
		int result = clientService.verifyClient(client_id);
		assertTrue("Failed to Register a Client",result==0);
	}
	

}
