package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.services.AppointmentService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/appointment")
@Controller
public class AppointmentController {

	@Autowired(required = true)
	private AppointmentService appointmentService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String bookAppointment(Model model) {

		model.addAttribute("appointment", new Appointment());
		return "appointment/newappointment";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAppointment(
			@ModelAttribute("appointment") Appointment appointment, Model model) {

		model.addAttribute("expectedTime", new Appointment());
		return "appointment/saveappointment";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllAppointments(Model model) {
		List<AppointmentDepartment> appointments;
		try {
			appointments = appointmentService.findAllUserAppointments(2);
			model.addAttribute("appointments", appointments);
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		return "appointment/view";
	}

	@RequestMapping(value = "/cancel/{appointmentId}", method = RequestMethod.GET)
	public String cancelAppointment(
			@PathVariable("appointmentId") int appointmentId,
			RedirectAttributes ra, Model model) {
		int rowsUpdated;

		try {
			rowsUpdated = appointmentService.cancelAppointment(appointmentId);
			model.addAttribute("result", "Updated: " + rowsUpdated + "fields");
			
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}

		return "redirect:/appointment/view";
	}

}
