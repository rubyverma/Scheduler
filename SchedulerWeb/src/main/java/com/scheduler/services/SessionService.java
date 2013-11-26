package com.scheduler.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;

@Component
@Scope("singleton")
public class SessionService {
	
	public Client client;
	public OfficialUser officialUser;
	public GeneralUser generalUser;
	public String userType;

}
