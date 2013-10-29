package com.scheduler.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AnnouncementMapper;
import com.scheduler.models.Announcement;

import com.scheduler.models.AppointmentList;
import com.scheduler.models.UserAnnouncement;

@Component
public class AnnouncementService {
	
	@Autowired(required = true)
	private AnnouncementMapper announcementMapper;

	public int addNewAnnouncement(Announcement announcement) {
		
		//TODO implement broadcast
		//announcement.setGcmMessageId("NOT IMPLEMENTED");
		return announcementMapper.addNewAnnouncement(announcement);
	}

	public boolean addUserAnnouncement(List<AppointmentList> listofAppointment,
			int announcement_id) {
		
		List<UserAnnouncement> userAnnouncements = new ArrayList<UserAnnouncement>();
		List<int> users = new ArrayList<int>();
		
		// create an userannouncement object with user_ids and announcent id
		for (AppointmentList appointment : listofAppointment) {
			
			UserAnnouncement userAnnouncement = new UserAnnouncement();
			userAnnouncement.setUserId(appointment.getUserId());
			userAnnouncement.setAnnouncementId(announcement_id);
			userAnnouncements.add(userAnnouncement);
			
			users.add(appointment.getUserId());
			
		}
		
		int rowsAffected = announcementMapper.addUserAnnouncement(userAnnouncements);
		return true;
	}

	public List<Announcement> getAllAnnouncements(int userId) throws BadSqlGrammarException{
		return announcementMapper.getAllAnnouncements(userId);
		
	}
}
