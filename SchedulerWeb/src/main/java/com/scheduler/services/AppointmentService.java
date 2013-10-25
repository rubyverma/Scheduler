package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.models.Appointment;
import com.scheduler.models.User;

@Component
public class AppointmentService {
	
	
	public  int saveAppointment(Appointment _app)  throws BadSqlGrammarException {
		return 1; //userMapper.saveUser(u);
	}
	
	
	public String expectedMeetingTime(int _appointmentId){
		
		return "Expected Time";
			
	}
	

}
