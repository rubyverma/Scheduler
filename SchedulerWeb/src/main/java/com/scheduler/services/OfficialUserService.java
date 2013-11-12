package com.scheduler.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.ClientMapper;
import com.scheduler.mappers.OfficialUserMapper;
import com.scheduler.models.Appointment;
import com.scheduler.models.OfficialUser;

@Component
public class OfficialUserService {

	@Autowired(required=true)
	private OfficialUserMapper officialMapper;

	public List<OfficialUser> getOfficialUserByDepartment(int departmentId){
		return officialMapper.getOfficialUserByDepartment(departmentId);
	}
	
	// Author - Shalin Banjara
	// Usage - To save the appointment booked by the user. Validations are performed on the UI.
	public int saveOfficialUser(OfficialUser officialUser) throws BadSqlGrammarException {
		return officialMapper.saveOfficialUser(officialUser);
	}
	
	public int deleteOfficialUser(@Param("officialId") int officialId) throws BadSqlGrammarException {
		return officialMapper.deleteOfficialUser(officialId);
	}
	
	public OfficialUser getOfficialUserById(@Param("officialId") int officialId) throws BadSqlGrammarException {
		return officialMapper.getOfficialUserById(officialId);
	}
	
	public int updateOfficialUser(OfficialUser officialUser) throws BadSqlGrammarException {
		return officialMapper.updateOfficialUser(officialUser);
	}
}
