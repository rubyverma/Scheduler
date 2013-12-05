package com.scheduler.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.scheduler.mappers.OfficialUserMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import com.scheduler.models.OfficialUser;

@Component
public class OfficialUserService {

	@Autowired(required = true)
	private OfficialUserMapper officialUserMapper;

	public OfficialUser authenticate(OfficialUser o) {

		OfficialUser i1 = officialUserMapper.authenticate(o);
		if (i1 == null) {
			i1 = new OfficialUser();
			i1.setOfficialId(0);
			return i1;
		}
		return i1;
	}

	public String getFirstName(String userName, String password) {

		return officialUserMapper.getFirstName(userName, password);
	}

	public int getOfficialId(String userName, String password) {

		return officialUserMapper.getOfficialId(userName, password);
	}

	public int resetPassword(String email,String myPassword) {
		 return officialUserMapper.resetPassword(email,myPassword);

		}

	
	public List<OfficialUser> getOfficialUserByDepartment(int departmentId){
		return officialUserMapper.getOfficialUserByDepartment(departmentId);
	}
	
	// Author - Shalin Banjara
	// Usage - To save the appointment booked by the user. Validations are performed on the UI.
	public int saveOfficialUser(OfficialUser officialUser) throws BadSqlGrammarException {
		return officialUserMapper.saveOfficialUser(officialUser);
	}
	
	public int deleteOfficialUser(@Param("officialId") int officialId) throws BadSqlGrammarException {
		return officialUserMapper.deleteOfficialUser(officialId);
	}
	
	public OfficialUser getOfficialUserById(@Param("officialId") int officialId) throws BadSqlGrammarException {
		return officialUserMapper.getOfficialUserById(officialId);
	}
	
	public int updateOfficialUser(OfficialUser officialUser) throws BadSqlGrammarException {
		return officialUserMapper.updateOfficialUser(officialUser);
	}

	public int updatePassword(OfficialUser officialUser) {
		return officialUserMapper.updatePassword(officialUser);
	}
	
	public int getStaffCount(int department_id) {
		return officialUserMapper.getStaffCount(department_id);
	}

}
