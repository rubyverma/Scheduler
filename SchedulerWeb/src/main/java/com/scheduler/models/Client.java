package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data
public class Client {
	
	private int m_clientId;
	private String m_clientName;
	private String m_userName;
	private String m_password;
	private String m_email;
	private String m_address;
	private String m_memo;
	private String m_logo;
	private String m_phone1;
	private String m_phone2;
	private String m_phone3;
	private String m_contactPerson;
	private String m_website;
	private String m_token;
	private int m_emailVerified;
	private Date m_dateJoined;
	
	public Client()
	{
		
	}
	
	public Client(int _clientId, String _clientName, String _userName, String _password, String _email,
					String _address, String _memo, String _logo, String _phone1, String _phone2, String _phone3,
					String _contactPerson, String _website, String _token, int _emailVerified, Date _dateJoined)
	{
		this.m_clientId = _clientId;
		this.m_clientName = _clientName;
		this.m_userName = _userName;
		this.m_password = _password;
		this.m_email = _email;
		this.m_address = _address;
		this.m_memo = _memo;
		this.m_logo = _logo;
		this.m_phone1 = _phone1;
		this.m_phone2 = _phone2;
		this.m_phone3 = _phone3;
		this.m_contactPerson = _contactPerson;
		this.m_website = _website;
		this.m_token = _token;
		this.m_emailVerified = _emailVerified;
		this.m_dateJoined = _dateJoined;
	}

}
