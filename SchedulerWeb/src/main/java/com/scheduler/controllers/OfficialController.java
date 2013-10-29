package com.scheduler.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.Announcement;
import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentList;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.Notification;
import com.scheduler.models.UserAnnouncement;
import com.scheduler.services.AnnouncementService;
import com.scheduler.services.AppointmentService;
import com.scheduler.services.NotificationService;

@RequestMapping("/official")
@Controller
@Slf4j
public class OfficialController {

	@Autowired(required = true)
	private AppointmentService appointmentService;

	@Autowired(required = true)
	private NotificationService notificationService;

	@Autowired(required = true)
	private AnnouncementService announcementService;

	@RequestMapping(value = "/meeting/finish", method = RequestMethod.POST)
	public String finishMeeting(
			@ModelAttribute("appointment") Appointment appointment, Model model) {
		// Code to Finish Appointment
		boolean meetingFinished = appointmentService
				.finishAppointment(appointment);
		if (meetingFinished) {
			model.addAttribute("finish", true);
		} else {
			model.addAttribute("finish", false);
		}
		// Redirecting to view the queue
		return "redirect:/official/meeting/viewqueue";
	}

	@RequestMapping(value = "/meeting/viewqueue", method = RequestMethod.GET)
	public String viewQueue(Model model) {
		System.out.println("view queue started");

		int departmentId=1;
		String appointmentDate="2013-11-13";
		List<AppointmentList> listofAppointment= appointmentService.getAllAppointment(departmentId,appointmentDate);
		model.addAttribute("appointmentList",listofAppointment);

// passing blank announcement object
		model.addAttribute("announcement", new Announcement());
		// Redirecting to view the queue
		return "meeting/viewqueue";
	}

	@RequestMapping(value = "/meeting/testmeeting", method = RequestMethod.GET)
	public String test(Model model) {
		return "meeting/meeting";
	}

	@RequestMapping(value = "/meeting/start", method = RequestMethod.GET)
	public String startMeeting(Model model) {

		// TODO insert the following fields to official user session
		// get official_id and dept_id from the session variable
		int official_id = 1234; // hardcoded value
		int department_id = 1; // hardcoded value

		Appointment nextAppointment = appointmentService
				.findNextAppointment(department_id);

		// Code to start appointment
		Appointment startedAppointment = appointmentService
				.startAppointmentById(nextAppointment.getAppointmentId(),
						official_id);

		if (!startedAppointment.equals(null)) {

			// Get next user in Queue (and send a push notification)
			GeneralUser nextUser = appointmentService
					.getNextUserInQueue(department_id);
			//
			Notification notification = new Notification();
			notification.setOfficialId(official_id);
			notification.setUserId(nextUser.getUserId());
			notification.setNotificationHeader("Meeting starting soon!");
			notification
					.setNotificationDescription("You are the next person in queue");
			boolean notifyNextUser = notificationService.notifyUser(
					nextUser.getGcmRegId(), notification);
			if (notifyNextUser) {
				model.addAttribute("nextUserNotified", true);
			}

			// if appointment is marked as started
			model.addAttribute("started", "true");
			model.addAttribute("appointment", startedAppointment);

		} else {

			// if appointment couldn't be marked as started
			model.addAttribute("started", "false");
		}

		return "meeting/meeting";

	}

	@RequestMapping(value = "/meeting/broadcast", method = RequestMethod.POST)
	public String broadcastMessage(
			@ModelAttribute("announcement") Announcement announcement,
			Model model) {
		log.info("Got " + announcement.getAnnouncementHeader());

		// TODO insert the following fields to official user session
		// get official_id and dept_id from the session variable
		int official_id = 1234; // hardcoded value

		announcement.setOfficialId(official_id);
		int announcement_id = announcementService
				.addNewAnnouncement(announcement);

		// List of appointments to which message has to be broadcasted
		List<AppointmentList> listofAppointment = appointmentService.getAllAppointment();

		boolean broadcasted = announcementService.addUserAnnouncement(
				listofAppointment, announcement_id,
				announcement.getAnnouncementHeader());

		// Redirecting to view the queue
		return "redirect:/official/meeting/viewqueue";
	}
	@RequestMapping(value = "meeting/late", method = RequestMethod.GET)
	public String userLate(RedirectAttributes ra, Model model) {

		int result;
		int appointmentId=1;
		try {
			result = appointmentService.userLate(appointmentId);
			model.addAttribute("result", result);
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}

		return "redirect:/official/meeting/viewqueue";
	}
}
