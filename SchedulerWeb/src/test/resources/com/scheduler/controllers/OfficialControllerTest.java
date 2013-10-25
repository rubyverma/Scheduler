package com.scheduler.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.scheduler.controllers.OfficialController;
import com.scheduler.models.Appointment;

public class OfficialControllerTest {

	@Test
	public void testFinishMeeting() {
		OfficialController official=new OfficialController();
		Appointment appointment= new Appointment();
		appointment.setAppointmentId(1);
		appointment.setMeetingNotes("Notes Recieved");
		official.finishMeeting(appointment,Model model)
//		fail("Failed");
	}

}
