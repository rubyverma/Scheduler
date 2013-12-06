package com.scheduler.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Appointment;

import static org.junit.Assert.*;

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
	
	@Test
	public void testCancelAppointment()
	{
		int AppointmentId=1;
		int testResult=appointmentService.cancelAppointment(AppointmentId);
		assertTrue("Failed to cancel appointment ",testResult==1);
	}

}
