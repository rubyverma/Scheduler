package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Campus;
import com.scheduler.services.CampusService;

@RequestMapping("/campus")
@Controller
public class CampusController {

	@Autowired(required = true)
	private CampusService campusService;
	private Campus campus;

	// Author - Ruby Verma
	// Usage - View all campus of a client
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllCampuses(Model model) {
		List<Campus> campuses;
		try {
			campuses = campusService.findAllCampuses(1);
			model.addAttribute("campuses", campuses);
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		model.addAttribute("campus", new Campus());
		return "campus/view";
	}

	// Author - Ruby Verma
	// Usage - Adds and save new campus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCampus(@ModelAttribute("campus") Campus campus,
			Model model) {

		campus.setClientId(1);
		int i = campusService.saveCampus(campus);

		return "redirect:/campus/view";
	}

	// Author - Ruby Verma
	// Usage - Delete selected campus
	@RequestMapping(value = "/delete/{campusId}", method = RequestMethod.GET)
	public String deleteCampus(@PathVariable("campusId") int campusId,
			RedirectAttributes ra, Model model) {
		int rowsUpdated;

		try {
			rowsUpdated = campusService.deleteCampus(campusId);
			model.addAttribute("result", "Deleted: " + rowsUpdated + "campus");

		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}

		return "redirect:/campus/view";
	}
	 
	// Author - Ruby Verma
	// Usage - Edit selected campus
	@RequestMapping(value = "/edit/{campusId}", method = RequestMethod.GET)
	public String editCampus(@PathVariable("campusId") int campusId, Model model) {
	   campus = campusService.getCampusById(campusId);
	   model.addAttribute("campus",campus);
	   return "campus/edit";
	}
	 
	// Author - Ruby Verma
	// Usage - Update existing campus
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String updateCampus(@ModelAttribute("campus") Campus campus,
				Model model) {

			campus.setClientId(1);
			int i = campusService.updateCampus(campus);
			return "redirect:/campus/view";
		}
}
