package com.scheduler.controllers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.Appointment;
import com.scheduler.models.Timeslot;
import com.scheduler.services.TimeslotService;

@RequestMapping("/timeslot")
@Controller
public class TimeslotController {

	// TODO hardcoded clientId -- need to replace with session
	private int clientId = 1;

	@Autowired(required = true)
	private TimeslotService timeslotService;

	// Author - Sonny
	// Usage - View the list of time slots for the clientId (from session)
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllTimeslots(
			@ModelAttribute("deleteResult") String deleteResult, Model model) {

		List<Timeslot> timeslots = timeslotService.GetAllTimeslots(clientId);
		model.addAttribute("timeslots", timeslots);
		model.addAttribute("deleteResult", deleteResult);
		model.addAttribute("timeslot", new Timeslot());
		return "timeslot/timeslotview";
	}

	// Author - Sonny
	// Usage - Save new timeslot to database
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addNewTimeslots(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {

		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("stopTime");
		String description = request.getParameter("description");

		Time startTimeObj = Time.valueOf(startTime + ":00");
		Time endTimeObj = Time.valueOf(endTime + ":00");
		
		Timeslot newTimeslot = new Timeslot();
		newTimeslot.setClientId(clientId);
		newTimeslot.setStartTime(startTimeObj);
		newTimeslot.setStopTime(endTimeObj);
		newTimeslot.setDescription(description);
		
		boolean saved = timeslotService.CreateNewTimeslot(newTimeslot);
		
		if(saved) {
			redirectAttributes.addFlashAttribute("result",
					"Timeslot added successfully");
		} else {
			redirectAttributes.addFlashAttribute("result",
					"Oops! Something went wrong");
		}
		
		return "redirect:/timeslot/view";
	}

	// Author - Sonny
	// Usage - Delete the time slot from the database
	@RequestMapping(value = "/delete/{timeslotId}", method = RequestMethod.GET)
	public String removeTimeslot(@PathVariable int timeslotId, Model model,
			RedirectAttributes redirectAttributes) {

		boolean deleted = timeslotService.RemoveTimeslot(timeslotId);
		if (deleted) {
			redirectAttributes.addFlashAttribute("result",
					"Timeslot removed successfully");
		} else {
			redirectAttributes
					.addFlashAttribute("result",
							"Unable to remove timeslot. Verify no department is using the timslot.");
		}

		return "redirect:/timeslot/view";
	}

}
