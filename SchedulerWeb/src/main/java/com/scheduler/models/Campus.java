package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data
public class Campus {
	
	private int m_campusId;
	private int m_clientId;
	private String m_campusName;
	private String m_campusAddress;
	private Date m_dateCreated;
	
	public Campus()
	{
		
		
	}
	
	public Campus(int _campusId, int _clientId, String _campusName,
					String _campusAddress, Date _dateCreated)
	{
		this.m_campusId = _campusId;
		this.m_clientId = _clientId;
		this.m_campusName = _campusName;
		this.m_campusAddress = _campusAddress;
		this.m_dateCreated = _dateCreated;
	}
	
}
