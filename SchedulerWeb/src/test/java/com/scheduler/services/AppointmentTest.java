package com.scheduler.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import com.scheduler.BaseTest;
import com.scheduler.models.Appointment;

public class AppointmentTest extends BaseTest {
	
	@Autowired(required = true)
	private AppointmentService appointmentService;
	
	@Test
	public void StartAppointmentTest() {
		int appointmentId = 1;
		int officialId = 3;
		Appointment startedAppointment = appointmentService.startAppointmentById(appointmentId, officialId);
		assertNotNull(startedAppointment);
	}

}
