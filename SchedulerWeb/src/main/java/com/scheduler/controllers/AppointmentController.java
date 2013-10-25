package com.scheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Appointment;
import com.scheduler.models.User;

@RequestMapping("/appointment")
@Controller
public class AppointmentController {
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String bookAppointment(Model model) {
		
		model.addAttribute("appointment", new Appointment());
		return "appointment/newappointment";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
		
		model.addAttribute("expectedTime", new Appointment());
		return "appointment/saveappointment";
	}

}
