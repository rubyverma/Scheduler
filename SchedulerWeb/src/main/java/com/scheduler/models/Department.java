package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data
public class Department {
	
	private int m_departmentId;
	private int m_campusId;
	private String m_departmentName;
	private String m_departmentHod;
	private int m_contactInfo;
	private String m_departmentDescription;
	private Date m_dateCreated;
	
	public Department()
	{
		
	}
	
	public Department(int _departmentId, int _campusId, String _departmentName, String _departmentHod,
						int _contactInfo, String _departmentDescription, Date _dateCreated)
	{
		this.m_departmentId = _departmentId;
		this.m_campusId = _campusId;
		this.m_departmentName = _departmentName;
		this.m_departmentHod = _departmentHod;
		this.m_contactInfo = _contactInfo;
		this.m_departmentDescription = _departmentDescription;
		this.m_dateCreated = _dateCreated;
	}
}
