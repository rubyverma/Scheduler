package com.scheduler.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.mappers.GeneralUserMapper;
import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;

@Component
public class GeneralUserService {

	@Autowired(required = true)
	private GeneralUserMapper generalUserMapper;

	public String getUserGCMregId(int userId) {
		return generalUserMapper.getUserRegistrationId(userId);
	}

	public GeneralUser authenticate(GeneralUser gu) {

		GeneralUser i = generalUserMapper.authenticate(gu);
		if (i == null) {
			i = new GeneralUser();
			i.setUserId(0);
			return i;
		}
		return i;
	}

	public String getFirstName(String userName, String password) {

		return generalUserMapper.getFirstName(userName, password);
	}

	public int getUserId(String userName, String password) {

		return generalUserMapper.getUserId(userName, password);
	}

	public int saveUser(GeneralUser generaluser) throws BadSqlGrammarException {
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

	public int resetPassword(String email,String myPassword) {
		 return generalUserMapper.resetPassword(email,myPassword);

		}
	
	public boolean updateGCMRegId(GeneralUser user) {
		
		int rowsAffected = generalUserMapper.updateGCMRegId(user);
		
		if(rowsAffected > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public GeneralUser getGeneralUser(@Param("userId") int userId) {
		  return generalUserMapper.getGeneralUser(userId);
		}
	
	public int updateUser(GeneralUser generaluser)
	{
	  return generalUserMapper.updateUser(generaluser);
	}
	
	public int updatePassword(GeneralUser generaluser)
	{
	  return generalUserMapper.updatePassword(generaluser);
	}

	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return generalUserMapper.getClients();
	}

}
