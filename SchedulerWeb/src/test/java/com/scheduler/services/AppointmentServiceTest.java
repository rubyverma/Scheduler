package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;


public class AppointmentServiceTest extends BaseTest {

	
	@Autowired(required=true)
	private AppointmentService appointmentService;

	
	@Test
	public void testCancelAppointment()
	{
		int AppointmentId=1;
		int testResult=appointmentService.cancelAppointment(AppointmentId);
		assertTrue("Failed to cancel appointment ",testResult==1);
	}
	
}
