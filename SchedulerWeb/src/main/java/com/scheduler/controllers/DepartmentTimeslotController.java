package com.scheduler.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Appointment;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Utility;
import com.scheduler.services.DepartmentService;
import com.scheduler.services.DepartmentTimeslotService;

@RequestMapping("/departmenttimeslot")
@Controller
public class DepartmentTimeslotController {
	
	@Autowired(required = true)
	private DepartmentTimeslotService departmentTimeslotService;
	
	@RequestMapping(value = "/gettimeslotcombo/{idDate}", method = RequestMethod.GET)
	public String getTimeslotByDepartment(@PathVariable("idDate") String idDate, Model model) {
		String[] s = idDate.split(":");
		System.out.println(s[1]);
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-mm-dd").parse(s[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility u = new Utility(Integer.parseInt(s[0]), d);
		System.out.println(u.getDepartmentId() + " - "+ u.getAppointmentDate());
		List<DepartmentTimeslotLinkage> availableTimeslots = departmentTimeslotService.timeslotByDepartment(u);
		model.addAttribute("availableTimeslots", availableTimeslots);
		return "partials/timeslotcombo";
	}

}
