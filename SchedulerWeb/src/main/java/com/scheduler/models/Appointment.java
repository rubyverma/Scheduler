package com.scheduler.models;
import java.sql.Date;

import lombok.Data;

@Data
public class Appointment {
	
	private int m_appointmentId;
	private int m_departmentTimeId;
	private int m_userId;
	private int m_officialId;
	private String m_purposeOfVisit;
	private Date m_startTime;
	private Date m_endTime;
	private String m_meetingFinished;
	private String m_meetingNotes;
	private Date m_dateCreated;
	
	
	
	
	public Appointment()
	{
		
		
	}
	public Appointment(int _appointmentId, int _departmentTimeId, int _userId, int _officialId,
						String _purposeOfVisit, Date _startTime, Date _endTime, String _meetingFinished,
						String _meetingNotes, Date _dateCreated)
	{
		this.m_appointmentId = _appointmentId;
		this.m_departmentTimeId = _departmentTimeId;
		this.m_userId = _userId;
		this.m_officialId = _officialId;
		this.m_purposeOfVisit = _purposeOfVisit;
		this.m_startTime = _startTime;
		this.m_endTime = _endTime;
		this.m_meetingFinished = _meetingFinished;
		this.m_meetingNotes = _meetingNotes;
		this.m_dateCreated = _dateCreated;
		
	}

}
