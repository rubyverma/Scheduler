package com.scheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.ClientMapper;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Category;
import com.scheduler.models.Client;
import com.scheduler.models.Faq;

@Component
public class ClientService {

	@Autowired(required=true)
	private ClientMapper clientMapper;
	
	
	public int saveClient(Client client) throws BadSqlGrammarException
	{
		return clientMapper.saveClient(client);
	}

	public int verifyClient(int client_id) {
		return clientMapper.verifyClient(client_id);

	}

	public String getClientToken(int client_id) {
		// TODO Auto-generated method stub
		return clientMapper.getClientToken(client_id);
	}

	
	public Client authenticate(Client c) {
		
		Client i = clientMapper.authenticate(c);
		if(i == null) {
			i = new Client();
			i.setClientId(0);
			return i;
		}
		return i;
	}
	
   public String getClientName(String userName,String password) {
		
		return clientMapper.getClientName(userName,password);
	}
   public int getClientId(String userName,String password) {
		
		return clientMapper.getClientId(userName,password);
	}
	
	public int getLastClientId() {
		// TODO Auto-generated method stub
		return clientMapper.getLastClientId();
	}
	
	public int resetPassword(String email,String myPassword) {
	 return clientMapper.resetPassword(email,myPassword);

	}
	
	public List<Faq> getFaqQns(int categoryId)
	{
		return clientMapper.getFaqQns(categoryId);
	}
	public List<Category> findAllCategories()
			throws BadSqlGrammarException {
		return clientMapper.findAllCategories();

	}
}
