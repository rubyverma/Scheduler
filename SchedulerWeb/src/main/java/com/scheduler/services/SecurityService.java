package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.SecurityMapper;
import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;

@Component
public class SecurityService {

	@Autowired
	private SecurityMapper securityMapper;
	
	public GeneralUser getUserByEmail(String email) {
		return securityMapper.getUserByEmail(email);
	}

	public OfficialUser getOfficialByEmail(String email) {
		return securityMapper.getOfficialByEmail(email);
	}

	public Client getClientByEmail(String email) {
		return securityMapper.getClientByEmail(email);
	}

}
