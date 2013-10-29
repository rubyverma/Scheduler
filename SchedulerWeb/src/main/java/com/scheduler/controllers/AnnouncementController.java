package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Announcement;
import com.scheduler.services.AnnouncementService;

@RequestMapping("/generaluser")
@Controller
public class AnnouncementController {

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
}
