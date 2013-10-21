package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data

public class Roles {
	private int m_roleId;
	private int m_clientId;
	private String m_roleName;
	private String m_privilege;
	private String m_description;
	
	public Roles(){
		
	}
	public Roles(int _roleId, int _clientId, String _roleName, String _privilege, String _description){
		m_roleId = _roleId;
		m_clientId = _clientId;
		m_roleName = _roleName;
		m_privilege = _privilege;
		m_description = _description;
	}
}
