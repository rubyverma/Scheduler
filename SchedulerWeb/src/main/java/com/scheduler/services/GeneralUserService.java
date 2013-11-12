package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.GeneralUserMapper;
import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;

@Component
public class GeneralUserService {
	
    @Autowired(required = true)
    private GeneralUserMapper generalUserMapper;
    
    public String getUserGCMregId(int userId){
    	return generalUserMapper.getUserRegistrationId(userId);
    }
   
public GeneralUser authenticate(GeneralUser gu) {
		
		GeneralUser i = generalUserMapper.authenticate(gu);
		if(i == null) {
			i = new GeneralUser();
			i.setUserId(0);
			return i;
		}
		return i;
	}
	
   public String getFirstName(String userName,String password) {
		
		return generalUserMapper.getFirstName(userName,password);
	}
   public int getUserId(String userName,String password) {
		
		return generalUserMapper.getUserId(userName,password);
	}
	
}
