package com.scheduler.services;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AppointmentMapper;
import com.scheduler.models.Appointment;
import com.scheduler.models.GeneralUser;
import com.scheduler.request.SendPostRequest;

@Component
public class AppointmentService {
	
	
	public  int saveAppointment(Appointment _app)  throws BadSqlGrammarException {
		return 1; //userMapper.saveUser(u);
	}
	
	
	public String expectedMeetingTime(int _appointmentId){
		
		return "Expected Time";
			
	}
	
    @Autowired(required = true)
    private AppointmentMapper appointmentMapper;
    
    @Autowired(required = true)
    private NotificationService notificationService;
    	
   @Autowired(required = true)
   private SendPostRequest postRequest;
   
    /* this function is to start an appointment by providing an appointment_id */
	public Appointment startAppointmentById(@Param("id") int app_id, @Param("official_id") int official_id )  throws BadSqlGrammarException {
		
		// get appointment object
		Appointment appointment = appointmentMapper.getAppointmentById(app_id);
		
		// start appointment by updating the row in appointment table
		int started = appointmentMapper.startAppointmentById(app_id, official_id);
		if(started > 0)
		{
			// if appointment is started, notify the next user
			GeneralUser generalUser = appointmentMapper.getUserByAppointmentId(app_id);
			String registration_id = generalUser.getGcmRegId();
			if(!registration_id.equals(null) || !registration_id.equals(""))
			{
				notificationService.notifyUser(registration_id);
			}
			
		}
		return appointment;
		
	}
	
}
