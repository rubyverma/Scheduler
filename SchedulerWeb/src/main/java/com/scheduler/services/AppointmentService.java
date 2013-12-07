package com.scheduler.services;


import java.sql.Date;
import java.util.List;

import com.scheduler.models.AppointmentList;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.Notification;
import com.scheduler.request.SendPostRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AppointmentMapper;
import com.scheduler.models.Appointment;

@Component
public class AppointmentService {

	@Autowired(required = true)
	private AppointmentMapper appointmentMapper;

	@Autowired(required = true)
	private NotificationService notificationService;
	
	@Autowired(required = true)
	private ExpectedMeetingTimeService expectedMeetingTimeService;

	@Autowired(required = true)
	private SendPostRequest postRequest;
	
	
	// Author - Shalin Banjara
	// Usage - To save the appointment booked by the user. Validations are performed on the UI.
	public int saveAppointment(Appointment appointment) throws BadSqlGrammarException {
		return appointmentMapper.saveAppointment(appointment);
	}

	// Author - Shalin Banjara
	// Usage - To calculate the expected meeting time for a booked unfinished appointment
	public String expectedMeetingTime(int appointmentId, Date appointmentDate) {
		
		

		
		return("Meeting Time");
	}

	public boolean finishAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		// Appointment apptest=new Appointment();
		// apptest.setMeetingNotes(meeting_notes);
		// apptest.setAppointmentId(appointment_id);
		if (appointmentMapper.finishAppointment(appointment) > 0) {
			return true;
		} else {
			return false;
		}
	}

		

	/* this function is to start an appointment by providing an appointment_id */
	public Appointment startAppointmentById(@Param("id") int app_id, @Param("official_id") int official_id) throws BadSqlGrammarException {


		// get appointment object
		Appointment appointment = appointmentMapper.getAppointmentById(app_id);

		// start appointment by updating the row in appointment table
		int started = appointmentMapper.startAppointmentById(app_id,
				official_id);
		if (started > 0) {
			// if appointment is started, notify the next user
			GeneralUser generalUser = appointmentMapper.getUserByAppointmentId(app_id);
			String registration_id = generalUser.getGcmRegId();
			
			Notification notification = new Notification();
			notification.setOfficialId(official_id);
			notification.setUserId(generalUser.getUserId());
			notification.setNotificationHeader("Meeting ready to be started");
			notification.setNotificationDescription("Please come in to the department");
			notification.setReadByUser(0);
			notificationService.notifyUser(registration_id, notification);

		}
		return appointment;

	}

	public List<AppointmentList> getAllAppointment(@Param("departmentId") int departmentId)
	{
		return appointmentMapper.getAllAppointment(departmentId);
	}

	public List<AppointmentDepartment> findAllUserAppointments(int userId)
			throws BadSqlGrammarException {
		List<AppointmentDepartment> appointments = appointmentMapper.findAllUserAppointments(userId) ;
		for(AppointmentDepartment app:appointments){
			app.setExpectedTime(expectedMeetingTimeService.getExpectedMeetingTime(app.getAppointmentId()));
		}
		return appointments;
	}
	
	// finds which appointment is in the top of the queue
	public Appointment findNextAppointment(int department_id)
	{
		return appointmentMapper.findNextAppointment(department_id);
	}


	public GeneralUser getNextUserInQueue(int department_id) {
		
		return appointmentMapper.getNextUserInQueue(department_id);
	}

	public int cancelAppointment(@Param("appointmentId") int appointmentId)  throws BadSqlGrammarException {
		return appointmentMapper.cancelAppointment(appointmentId);
	}
	public int userLate(@Param("appointmentId") int appointmentId)  throws BadSqlGrammarException {
		return appointmentMapper.userLate(appointmentId);
	}
	
	public int getAppointmentCount(int departmentId)
	{
		return appointmentMapper.getAppointmentCount(departmentId);
	}
	
	public int getAppointmentCountByUserId(int userId)
	{
		return appointmentMapper.getAppointmentCountByUserId(userId);
	}
	
	public int getAppointmentCountByClientId(int clientId) {
		return appointmentMapper.getAppointmentCountByClientId(clientId);
	}

}
