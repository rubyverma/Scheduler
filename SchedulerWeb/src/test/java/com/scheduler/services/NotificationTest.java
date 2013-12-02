package com.scheduler.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Notification;

import static org.junit.Assert.*;

public class NotificationTest extends BaseTest {
	
	@Autowired(required = true)
	private NotificationService notificationService;
	
	@Test
	public void SendNotificationToUserTest() {
		
		String testGcmRegId = "APA91bHrK0yuSyQ90exMyA46Ou_DQUkhsJG_20wmWBQTd-Y-AlHt_L-ky97idJ6Vq3x2INzzk3cutl5P95ISd5UCiSPbicDUxA_0ZzvHu-4L_xP-avjCiVA0MMattuqkhJFl0DKIYR93bLySnYZntfXcLoM9GZQoP8LooAsirCUQBWT6f6IgxXc";
		String notificationDescription = "Your meeting is starting now!";
		//create test notification object
		Notification notification = new Notification();
		notification.setNotificationDescription(notificationDescription);
		
		Boolean notificationSent = notificationService.notifyUser(testGcmRegId, notification);
		assertTrue(notificationSent);
	}

}
