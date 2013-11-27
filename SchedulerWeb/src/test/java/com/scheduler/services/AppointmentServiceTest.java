package com.scheduler.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Appointment;

public class AppointmentServiceTest extends BaseTest {

	@Autowired(required=true)
	private AppointmentService appointmentService;
	@Test
	public void testFinishAppointment() {
		Appointment appointment= new Appointment();
		appointment.setAppointmentId(1);
		appointment.setDepartmentTimeId(1);
		appointment.setUserId(1);
		appointment.setOfficialId(1234);
		appointment.setPurposeOfVisit("Course Enquiry");
		boolean testResult= appointmentService.finishAppointment(appointment);
		
		assertTrue("Failed to finish appointment",testResult==true);
	}

}
