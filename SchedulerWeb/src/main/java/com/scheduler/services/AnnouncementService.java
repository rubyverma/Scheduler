package com.scheduler.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AnnouncementMapper;
import com.scheduler.mappers.GeneralUserMapper;
import com.scheduler.models.Announcement;
import com.scheduler.models.AppointmentList;
import com.scheduler.models.UserAnnouncement;
import com.scheduler.request.SendPostRequest;

@Component
public class AnnouncementService {
	
	@Autowired(required = true)
	private AnnouncementMapper announcementMapper;
	
	@Autowired(required = true)
	private GeneralUserMapper generalUserMapper;

	public int addNewAnnouncement(Announcement announcement) {
		
		//TODO implement broadcast
		//announcement.setGcmMessageId("NOT IMPLEMENTED");
		int rows = announcementMapper.addNewAnnouncement(announcement);
		return announcement.getAnnouncementId();
	}

	public boolean addUserAnnouncement(List<AppointmentList> listofAppointment,
			int announcement_id, String title, String message) {
		
		List<UserAnnouncement> userAnnouncements = new ArrayList<UserAnnouncement>();
		List<String> deviceRegIds = new ArrayList<String>();
		
		// create an userannouncement object with user_ids and announcent id
		for (AppointmentList appointment : listofAppointment) {
			
			UserAnnouncement userAnnouncement = new UserAnnouncement();
			userAnnouncement.setUserId(appointment.getUserId());
			userAnnouncement.setAnnouncementId(announcement_id);
			userAnnouncements.add(userAnnouncement);
			
			deviceRegIds.add(generalUserMapper.getUserRegistrationId(appointment.getUserId()));
		}
		
		int rowsAffected = announcementMapper.addUserAnnouncement(userAnnouncements);
		
		SendPostRequest request = new SendPostRequest();
		String multicast_id = request.multicastMessage(deviceRegIds, title, message);
		return true;
	}

	public List<Announcement> getAllAnnouncements(int userId) throws BadSqlGrammarException{
		return announcementMapper.getAllAnnouncements(userId);
		
	}
}
