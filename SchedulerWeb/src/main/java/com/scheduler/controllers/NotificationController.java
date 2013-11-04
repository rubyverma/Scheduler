package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scheduler.models.Notification;
import com.scheduler.services.NotificationService;



@RequestMapping("/generaluser")
@Controller
public class NotificationController {

	protected static final String JSON_CONTENT = "application/json";
	
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
	
	// Android App fetches all the notifications for an individual user
	
	@RequestMapping(value = "/getnotifications/{id}" , method = RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public List<Notification> getAllNotifications(@PathVariable int id)
	{
		
		try{
			List<Notification> notification = null;
			notification = notificationService.findAllNotifications(id);
			return notification ;
		}
	catch(BadSqlGrammarException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	
	}
	
}
