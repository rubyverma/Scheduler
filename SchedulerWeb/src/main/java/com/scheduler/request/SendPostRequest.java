package com.scheduler.request;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Component
public class SendPostRequest {

	private static final String API_KEY = "AIzaSyALsNzA33zOh51g0ECjYcGWtA2y3hbcZaY";

	public boolean sendNotification(String registration_id, String notificationMessage) {
		Result result;
		
		Sender sender = new Sender(API_KEY);// add your own google APIkey here

		// use this to send message with payload data
		Message message = new Message.Builder().collapseKey("message")
				.timeToLive(3).delayWhileIdle(true)
				.addData("message", notificationMessage) // you can get this
															// message on client
															// side app
				.build();

		try {
			result = sender.send(message, registration_id, 1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
