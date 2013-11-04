package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Appointment;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Utility;
import com.scheduler.services.DepartmentTimeslotService;

@RequestMapping("/departmenttimeslot")
@Controller
public class DepartmentTimeslotController {

	@Autowired(required = true)
	private DepartmentTimeslotService departmentTimeslotService;

	// Author - Shalin Banjara
	// Usage - Returns available timeslots as per capacity and day for the
	// selected department
	@RequestMapping(value = "/gettimeslotcombo/{idDate}", method = RequestMethod.GET)
	public String getTimeslotByDepartment(
			@PathVariable("idDate") String idDate, Model model) {
		System.out.println(idDate);
		String[] s = idDate.split(":");

		Utility u = new Utility(Integer.parseInt(s[0]), s[1]);
		System.out
				.println(u.getDepartmentId() + " - " + u.getAppointmentDate());
		List<DepartmentTimeslotLinkage> availableTimeslots = departmentTimeslotService
				.timeslotByDepartment(u);
		model.addAttribute("availableTimeslots", availableTimeslots);
		model.addAttribute("appointment", new Appointment());
		return "partials/timeslotcombo";
	}

}
