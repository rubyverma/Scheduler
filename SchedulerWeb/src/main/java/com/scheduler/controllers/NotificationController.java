package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Notification;
import com.scheduler.services.NotificationService;


@RequestMapping("/generaluser")
@Controller
public class NotificationController {

	@Autowired(required = true)
	private NotificationService notificationService;
	
	@RequestMapping(value = "/notifications" , method = RequestMethod.GET)
	public String viewAllNotifications(Model model)
	{
		List<Notification> notifications = null;
			try{
		            int userId = 1;//This is to be feteched from session
					notifications = notificationService.findAllNotifications(userId);
					model.addAttribute("notifications", notifications);
		
				}
			catch(BadSqlGrammarException e)
				{
					model.addAttribute("ERROR",e.getMessage());
					System.out.println(e.getMessage());
				}
			return "generaluser/viewNotifications";
	
	}
}
