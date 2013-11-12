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
	
}
