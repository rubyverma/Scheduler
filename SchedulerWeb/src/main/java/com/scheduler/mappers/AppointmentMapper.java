package com.scheduler.mappers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Appointment;

@Repository(value="appointmentMapper")
@Component
public interface AppointmentMapper {
	
	int finishAppointment(Appointment apptest);
}
