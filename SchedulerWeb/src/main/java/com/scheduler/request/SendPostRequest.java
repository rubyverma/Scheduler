package com.scheduler.request;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Component
public class SendPostRequest {

	private static final String API_KEY = "AIzaSyALsNzA33zOh51g0ECjYcGWtA2y3hbcZaY";

	public String sendNotification(String registration_id, String notificationMessage) {
		
		String message_id = "";
		Result result;
		
		Sender sender = new Sender(API_KEY);

		// use this to send message with payload data
		Message message = new Message.Builder().collapseKey("message")
				.timeToLive(3).delayWhileIdle(true)
				.addData("message", notificationMessage) // you can get this
															// message on client
															// side app
				.build();

		try {
			result = sender.send(message, registration_id, 1);
			message_id = result.getMessageId();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message_id;
	}
	
	public void multicastMessage(List<String> devices, String messageToSend) {
		
		Sender sender = new Sender(API_KEY);
		
		Message message = new Message.Builder().collapseKey("1")
				.timeToLive(3)
				.delayWhileIdle(true)
				.addData("message",  messageToSend)
				.build();


		
		try {
			MulticastResult result = sender.send(message, devices, 1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
