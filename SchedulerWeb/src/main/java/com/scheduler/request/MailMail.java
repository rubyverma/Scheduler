package com.scheduler.request;

import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;






public class MailMail {

	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String dear, String content,String to) {

		try
		{

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("schedulerapp1234@gmail.com");
		message.setTo(to);
		message.setSubject("Scheduler App");
		message.setText(String.format(

		simpleMailMessage.getText(), dear, content));
		mailSender.send(message);
		}
		
	    catch(MailSendException mse) {
			mse.printStackTrace();

		}
		/*SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		
		message.setText(String.format(
				simpleMailMessage.getText(), dear, content));
		message.setTo(to);

		mailSender.send(message); */
		
	}
}
