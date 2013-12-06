package com.schedulerapp.models;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Notification {
	
	private int notificationId;
	public Notification() {
		// TODO Auto-generated constructor stub
	}

	private int officialId;
	private int userId;
	private String gcmMessageId;
	private String notificationHeader;
	private String notificationDescription;
	private int readByUser;
	private Date notificationDate;
	
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public int getOfficialId() {
		return officialId;
	}
	public void setOfficialId(int officialId) {
		this.officialId = officialId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGcmMessageId() {
		return gcmMessageId;
	}
	public void setGcmMessageId(String gcmMessageId) {
		this.gcmMessageId = gcmMessageId;
	}
	public String getNotificationHeader() {
		return notificationHeader;
	}
	public void setNotificationHeader(String notificationHeader) {
		this.notificationHeader = notificationHeader;
	}
	public String getNotificationDescription() {
		return notificationDescription;
	}
	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}
	public int getReadByUser() {
		return readByUser;
	}
	public void setReadByUser(int readByUser) {
		this.readByUser = readByUser;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	public static Notification getNotificationFromJson(JSONObject obj) throws JSONException {
	      Notification notification = new Notification();
	      notification.setNotificationId(obj.getInt("notificationId"));
	      notification.setOfficialId(obj.getInt("officialId"));
	      notification.setGcmMessageId(obj.getString("gcmMessageId"));
	      notification.setNotificationHeader(obj.getString("notificationHeader"));
	      notification.setNotificationDate(Date.valueOf(obj.getString("notificationDate")));
	      notification.setNotificationDescription(obj.getString("notificationDescription"));
	      notification.setReadByUser(obj.getInt("readByUser"));
	      notification.setUserId(obj.getInt("userId"));
	      return notification;
	    }   
	
	public Notification(String notificationHeader,
			String notificationDescription, Date NotificationDate) {
		super();
		this.notificationHeader = notificationHeader;
		this.notificationDescription = notificationDescription;
		this.notificationDate=NotificationDate;
	}

}
