package com.scheduler.services;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Announcement;

public class AnnouncementServiceTest extends BaseTest {

	@Autowired(required = true)
	AnnouncementService announcementService;

	@Test
	public void testGetAllAnnouncements() {
		Announcement newAnnoucement = new Announcement();
		newAnnoucement.setAnnouncementId(12);
		newAnnoucement.setOfficialId(2);
		newAnnoucement.setAnnouncementHeader("Announcement Test");
		newAnnoucement.setAnnouncementDescription("Announcement announced");
		newAnnoucement.setGcmMessageId(String.valueOf(2456));
		newAnnoucement.setAnnouncementDate(Date.valueOf("2013-12-05"));

		announcementService.addNewAnnouncement(newAnnoucement);

		List<Announcement> announcements = announcementService
				.getAllAnnouncements(1);
		assertNotNull(announcements);
		assertTrue(announcements.size() >= 0);
	}
	
	@Test
	public void SendAnnouncementTest() {
		// Broadcasting message is saved in announcement table
		Announcement announcement = new Announcement();
		announcement.setOfficialId(1);
		announcement.setAnnouncementHeader("College will be closed");
		announcement.setAnnouncementDescription("Emergency on campus");
		announcement.setGcmMessageId("SimpleMessageID");
		int announcementId = announcementService.addNewAnnouncement(announcement);
		assertTrue("Failed to add broadcast message", announcementId > 0);
		
	}
}
