package com.scheduler.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;

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
