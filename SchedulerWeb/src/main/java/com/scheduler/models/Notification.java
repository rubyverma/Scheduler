package com.scheduler.models;
import java.sql.Date;
import lombok.Data;

@Data

public class Notification {
	
	private int m_notificationId;
	private int m_officialId;
	private int m_userId;
	private int m_gcmMessageId;
	private String m_notificationHeader;
	private String m_notificationDescription;
	private int m_readByUser;
	private Date m_notificationDate;
	
	public Notification(){
		
	}
	public Notification(int _notificationId, int _officialId, int _userId, int _gcmMessengerId, String _notificationHeader, String _notificationDescription, int _readByUser, Date _notificationDate){
		m_notificationId = _notificationId;
		m_officialId = _officialId;
		m_userId = _userId;
		m_gcmMessageId = _gcmMessengerId;
		m_notificationHeader = _notificationHeader;
		m_notificationDescription = _notificationDescription;
		m_readByUser = _readByUser;
		m_notificationDate = _notificationDate;
	}
}
