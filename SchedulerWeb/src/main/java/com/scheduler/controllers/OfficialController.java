package com.scheduler.controllers;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Appointment;
import com.scheduler.models.User;
import com.scheduler.services.AppointmentService;

@RequestMapping("/appointment")
@Controller

public class OfficialController {

	@Autowired(required=true)
	private AppointmentService appointmentService;
	
	@RequestMapping(value="/meeting/finish",method=RequestMethod.POST)
	
	public String finishMeeting(@ModelAttribute("appointment") Appointment appointment,Model model)
	//public String finishMeeting(HttpServletRequest req,Model model)
	{
		
		//Appointment appointment=new Appointment();
		//appointment.setAppointmentId(Integer.parseInt(req.getParameter("appointment_id")));
		//appointment.setMeetingNotes(req.getParameter("meeting_notes"));
		boolean meetingFinished=appointmentService.finishAppointment(appointment);
		if(meetingFinished)
		{
			model.addAttribute("finish", true);
		}
		else
		{
			model.addAttribute("finish",false);
		}
		return "meeting/meeting";
	}
	
	@RequestMapping(value="/meeting/testmeeting",method=RequestMethod.GET)
	public String test(Model model)
	{
		return "meeting/meeting";
	}
}
