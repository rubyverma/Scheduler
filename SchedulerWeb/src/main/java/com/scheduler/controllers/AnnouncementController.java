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

import com.scheduler.models.Announcement;
import com.scheduler.services.AnnouncementService;

@RequestMapping("/generaluser")
@Controller
public class AnnouncementController {
	protected static final String JSON_CONTENT = "application/json";

	@Autowired(required = true)
	private AnnouncementService announcementService;
	
	@RequestMapping(value = "/announcements" , method = RequestMethod.GET)
	public String viewAllAnnouncements(Model model)
	{
		List<Announcement> announcements = null;
			try{
					announcements = announcementService.getAllAnnouncements(1);
					model.addAttribute("announcements", announcements);
		
				}
			catch(BadSqlGrammarException e)
				{
					model.addAttribute("ERROR",e.getMessage());
					System.out.println(e.getMessage());
				}
			return "generaluser/announcements";
	
	}
	
	// Android App fetches all the announcements for an individual user
	
	@RequestMapping(value = "/getannouncement/{id}" , method = RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public List<Announcement> getAnnouncement(@PathVariable int id)
	{
		
		try{
			List<Announcement> announcement = null;
			announcement = announcementService.getAllAnnouncements(id);
			return announcement ;
		}
	catch(BadSqlGrammarException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	
	}
}
