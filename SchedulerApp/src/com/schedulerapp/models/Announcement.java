package com.schedulerapp.models;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Announcement {
	
	private int announcementId;
	private int officialId;
	private String gcmMessageId;
	private String announcementHeader;
	private String announcementDescription;
	private Date announcementDate;
	
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public int getOfficialId() {
		return officialId;
	}
	public void setOfficialId(int officialId) {
		this.officialId = officialId;
	}
	public String getGcmMessageId() {
		return gcmMessageId;
	}
	public void setGcmMessageId(String gcmMessageId) {
		this.gcmMessageId = gcmMessageId;
	}
	public String getAnnouncementHeader() {
		return announcementHeader;
	}
	public void setAnnouncementHeader(String announcementHeader) {
		this.announcementHeader = announcementHeader;
	}
	public String getAnnouncementDescription() {
		return announcementDescription;
	}
	public void setAnnouncementDescription(String announcementDescription) {
		this.announcementDescription = announcementDescription;
	}
	public Date getAnnouncementDate() {
		return announcementDate;
	}
	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}
	
	public static Announcement getAnnouncementFromJson(JSONObject obj) throws JSONException {
	      Announcement announcement = new Announcement();
	    //  announcement.setAnnouncementId(obj.getInt("announcementId"));
	    //  announcement.setOfficialId(obj.getInt("officialId"));
	   //   announcement.setGcmMessageId(obj.getString("GcmMessageId"));
	      announcement.setAnnouncementHeader(obj.getString("announcementHeader"));
	      announcement.setAnnouncementDate(Date.valueOf(obj.getString("announcementDate")));
	      announcement.setAnnouncementDescription(obj.getString("announcementDescription"));
	      return announcement;
	    }   
}
