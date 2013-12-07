package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;

import com.scheduler.BaseTest;
import com.scheduler.models.Client;
import com.scheduler.models.DepartmentStatistics;

public class ClientServiceTest extends BaseTest {

	@Autowired(required = true)
	private ClientService clientService;

	@Test
	public void TestClientRegistration()
	{
		Client client= new Client();
		client.setClientName("testClient");
		client.setUserName("test");
		client.setPassword("test");
		client.setEmail("techrockers@yahoo.co.in");
		client.setAddress("test address");
		client.setMemo("test memo");
		client.setPhone1("test phone1");
		client.setPhone2("test phone2");
		client.setPhone3("test phone3");
		client.setLogo("test_logo.jpg");
		client.setContactPerson("Test Person");
		client.setWebsite("www.testwebsite.com");
		client.setToken("123456");
		int testResult= clientService.saveClient(client);
		assertTrue("Failed to Register a Client",testResult==1);
		
	}
	
	@Test
	public void testViewStatistic() {
		List<DepartmentStatistics> departmentStats = clientService.getStatistics();
		assertTrue("Failed to View Statistics",departmentStats.isEmpty() == false);
	}

}
