package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.NotificationMapper;
import com.scheduler.request.SendPostRequest;

@Component
public class NotificationService {

	@Autowired(required = true)
	private NotificationMapper notificationMapper;

	/* Get the user id, and and send a notification
	 * 1. Push notification
	 * 2. Add new row to notification table
	 */
	public boolean notifyUser(String registration_id) {

		// send notification and insert a row in notifications table

		String message = "Message";
		SendPostRequest p = new SendPostRequest();
		p.sendNotification(registration_id, message);
		return true;
	}
}
