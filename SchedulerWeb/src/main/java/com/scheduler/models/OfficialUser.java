package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data

public class OfficialUser {
	
	private int m_officialId;
	private int m_departmentId;
	private int m_roleId;
	private String m_officialName;
	private String m_password;
	private String m_email;
	private String m_firstName;
	private String m_lastName;
	private Date m_dateJoined;
	private Date m_lastLogin;
	
	public OfficialUser() {
		
	}
	public OfficialUser(int _officialId, int _departmentId, int _roleId, String _officialName, String _password, String _email, String _firstName, String _lastName, Date _dateJoined, Date _lastLogin){
		
		m_officialId = _officialId;
		m_departmentId = _departmentId;
		m_roleId = _roleId;
		m_officialName = _officialName;
		m_password = _password;
		m_email = _email;
		m_firstName = _firstName;
		m_lastName = _lastName;
		m_dateJoined = _dateJoined;
		m_lastLogin = _lastLogin;
	}

}
