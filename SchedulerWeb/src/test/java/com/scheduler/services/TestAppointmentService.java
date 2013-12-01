package com.scheduler.services;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;

public class TestAppointmentService extends BaseTest {

	@Autowired(required = true)
	private AppointmentService appointmentService;
	
	@Test
	public void testFindAllUserAppointments() {
	  Appointment newAppointment = new Appointment();
	  newAppointment.setAppointmentId(50);
	  newAppointment.setDepartmentTimeId(1);
	  newAppointment.setUserId(1);
	  newAppointment.setOfficialId(2);
	  newAppointment.setPurposeOfVisit("Visit");
	  newAppointment.setStartTime(Time.valueOf("12:00:00"));
	  newAppointment.setEndTime(Time.valueOf("12:15:00"));
	  newAppointment.setMeetingFinished("N");
	  newAppointment.setMeetingNotes("Notes");
	  newAppointment.setDateCreated(Date.valueOf("2013-11-30"));
	  newAppointment.setAppointmentDate(Date.valueOf("2013-12-2"));
	  appointmentService.saveAppointment(newAppointment);
	  
	  List<AppointmentDepartment> appointments = appointmentService.findAllUserAppointments(1);
	  assertNotNull(appointments);
	  assertTrue(appointments.size()>=0);
	  
	}
}
