package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Notification;

public class ViewNotificationsTest extends BaseTest {

	 @Autowired(required = true)
		private NotificationService notificationService;
	 
	 @Test
		public void testViewNotifications()
		{
		 List<Notification> notifications = null;
		 int id = 1;
		 notifications = notificationService.findAllNotifications(1);
		 assertTrue("Failed to find notifications",notifications==null);
		}
}
