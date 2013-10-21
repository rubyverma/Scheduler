package com.scheduler.models;
import java.sql.Date;
import lombok.Data;

@Data

public class GeneralUser {
	
	private int m_userId;
	private int m_clientId;
	private String m_userName;
	private String m_password;
	private String m_firstName;
	private String m_lastName;
	private String m_email;
	private Date m_dob;
	private String m_address;
	private String m_gender;
	
	public GeneralUser() {
		
	}

	public GeneralUser(int _userId,int _clientId, String _userName, String _password, String _firstName, String _lastName, String _email, Date _dob,String _address, String _gender){
		
		m_userId = _userId;
		m_clientId = _clientId;
		m_userName = _userName;
		m_password = _password;
		m_firstName = _firstName;
		m_lastName = _lastName;
		m_email = _email;
		m_dob = _dob;
		m_address = _address;
		m_gender = _gender;
	}
}
