package com.scheduler.models;
import java.sql.Date;

import lombok.Data;


@Data
public class Announcement {
	
	private int m_announcementId;
	private int m_officialId;
	private String m_announcementHeader;
	private String m_announcementDescription;
	private Date m_announcementDate;
	
	
	public Announcement()
	{
		
		
	
	}
	
	public Announcement(int _announcementId, int _officialId, String _announcementHeader, String _announcementDescription ,Date _announcementDate)
	{
		
		this.m_announcementId = _announcementId;
		this.m_officialId = _officialId;
		this.m_announcementHeader = _announcementHeader;
		this.m_announcementDescription = _announcementDescription;
		this.m_announcementDate = _announcementDate;
		
		
	
	}

}
