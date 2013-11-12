package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.ClientMapper;
import com.scheduler.models.Client;

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
	public int getLastClientId() {
		// TODO Auto-generated method stub
		return clientMapper.getLastClientId();
	}
	
}
