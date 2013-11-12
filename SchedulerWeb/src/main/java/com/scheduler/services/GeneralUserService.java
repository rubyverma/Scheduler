package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.GeneralUserMapper;
import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;

@Component
public class GeneralUserService {
	
    @Autowired(required = true)
    private GeneralUserMapper generalUserMapper;
    
    public String getUserGCMregId(int userId){
    	return generalUserMapper.getUserRegistrationId(userId);
    }

    public int saveUser(GeneralUser generaluser) throws BadSqlGrammarException
	{
		return generalUserMapper.saveUser(generaluser);
	}
	public int verifyUser(int userId) {
		return generalUserMapper.verifyUser(userId);

	}
	public String getUserToken(int userId) {
		// TODO Auto-generated method stub
		return generalUserMapper.getUserToken(userId);
	}
	public int getLastUserId() {
		// TODO Auto-generated method stub
		return generalUserMapper.getLastUserId();
	}
}
