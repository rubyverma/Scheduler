package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AppointmentMapper;
import com.scheduler.models.Appointment;

@Component
public class AppointmentService {

	@Autowired(required=true)
	private AppointmentMapper appointmentMapper;

	public boolean finishAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		//Appointment apptest=new Appointment();
		//apptest.setMeetingNotes(meeting_notes);
		//apptest.setAppointmentId(appointment_id);
		if (appointmentMapper.finishAppointment(appointment)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
