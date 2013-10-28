package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.NotificationMapper;
import com.scheduler.models.Notification;
import com.scheduler.request.SendPostRequest;

@Component
public class NotificationService {

	@Autowired(required = true)
	private NotificationMapper notificationMapper;

	/* Get the user id, and and send a notification
	 * 1. Push notification
	 * 2. Add new row to notification table
	 */
	public boolean notifyUser(String registration_id, Notification notification) {

		// push notification to mobile device
		String message = notification.getNotificationDescription();
		SendPostRequest p = new SendPostRequest();
		String message_id = p.sendNotification(registration_id, message);
		
		// add message_id to the notification object
		notification.setGcmMessageId(message_id);
		
		// insert a row in notifications table
		int createdNotificationId = addNewNotification(notification);
		if(createdNotificationId > 0)
			return true;
		else
			return false;
	}
	
	public int addNewNotification(Notification notification) 
	{
		return notificationMapper.addNewNotification(notification);
	}
}
