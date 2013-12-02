package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.AppointmentDepartment;

public class AppointmentServiceTest extends BaseTest {

	@Autowired(required=true)
	private AppointmentService appointmentService;


	@Test
	public void testLateAppointment(){
		int appointmentId=1;
		int testResult=appointmentService.userLate(appointmentId);
		assertTrue("Failed to mark the appointment as late",testResult==1);
	}

}
