package com.scheduler.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Campus;
import com.scheduler.services.CampusService;

@RequestMapping("/campus")
@Controller
public class CampusController {

	protected static final String JSON_CONTENT = "application/json";

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
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = JSON_CONTENT)
	@ResponseBody
	public int saveCampus(@RequestBody Campus campus) {
		campus.setClientId(1);
		int i = campusService.saveCampus(campus);
		return i;
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

		return "redirect:/campus/view?deleted=1";
	}

	// Author - Ruby Verma
	// Usage - Edit selected campus
	@RequestMapping(value = "/edit/{campusId}", method = RequestMethod.GET)
	public String editCampus(@PathVariable("campusId") int campusId, Model model) {
		campus = campusService.getCampusById(campusId);
		model.addAttribute("campus", campus);
		return "campus/edit";
	}

	// Author - Ruby Verma
	// Usage - Update existing campus
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCampus(@ModelAttribute("campus") Campus campus,
			Model model) {

		int count = campusService.validateEntry(campus);
		if (count > 0) {
			System.out.println("Already Exists");
			model.addAttribute("exists", 1);
			return "redirect:/campus/edit/" + campus.getCampusId();
		} else {
			campus.setClientId(1);
			int i = campusService.updateCampus(campus);
		}

		return "redirect:/campus/view";
	}

	// Author - Ruby Verma
	// Usage - Validates if campus already exists
	@RequestMapping(value = "/validate", method = RequestMethod.POST, produces = JSON_CONTENT)
	@ResponseBody
	public int validateCampus(@RequestBody Campus campus) {
		int count = campusService.validateEntry(campus);
		return count;
	}
}
