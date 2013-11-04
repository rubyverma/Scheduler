package com.scheduler.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Campus;
import com.scheduler.services.AppointmentService;
import com.scheduler.services.CampusService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/appointment")
@Controller
public class AppointmentController {

	protected static final String JSON_CONTENT = "application/json";
	@Autowired(required = true)
	private AppointmentService appointmentService;
	@Autowired(required = true)
	private CampusService campusService;
	// TODO fetch userId and clientId from the session when user Login into the
	// system
	public int userId = 1;
	public int clientId = 1;

	// Author - Shalin Banjara
	// Usage - Displays the book appointment page to the user
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String bookAppointment(Model model) {

		List<Campus> campuses = campusService.campusByClient(clientId);
		// Stub to see the list of campuses based on client
		System.out.println("List of campuses" + campuses.toString());

		model.addAttribute("campuses", campuses);
		return "appointment/newappointment";
	}

	// Author - Shalin Banjara
	// Usage - Save the appointment and redirects the user to view all their
	// appointments
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAppointment(
			@ModelAttribute("appointment") Appointment appointment, Model model) {

		appointment.setUserId(userId);
		appointment.setMeetingFinished("N");
		int i = appointmentService.saveAppointment(appointment);
		return "redirect:/appointment/view";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllAppointments(Model model) {
		List<AppointmentDepartment> appointments;
		try {
			appointments = appointmentService.findAllUserAppointments(1);
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
	
	@RequestMapping(value = "/mobileview/{userId}", method = RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public List<AppointmentDepartment> viewAllAppointments(@PathVariable("userId") String userId) {
		int id = Integer.parseInt(userId);
		List<AppointmentDepartment> appointments;
		appointments = appointmentService.findAllUserAppointments(id);
		return appointments;
	}

}
