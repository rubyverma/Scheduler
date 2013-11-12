package com.scheduler.controllers;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.GeneralUser;
import com.scheduler.request.MailMail;
import com.scheduler.services.GeneralUserService;

@RequestMapping("/generaluser")
@Controller
@Slf4j
public class GeneralUserController {

	@Autowired(required = true)
	private GeneralUserService generaluserService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("generaluser", new GeneralUser());
		return "generaluser/registergeneraluser";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("generaluser") GeneralUser generaluser, Model model)
	{
		String token;
		int userId;
		if (generaluser!=null)
		{
			String to = generaluser.getEmail().toString();
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			Random randomGenerator = new Random();
			int mytoken =randomGenerator.nextInt(999999-100000)+100000;
			generaluser.setTocken(""+mytoken);
			System.out.println(generaluser.getTocken());			
			int result = generaluserService.saveUser(generaluser);

			userId= generaluserService.getLastUserId();
			
			token = generaluserService.getUserToken(userId);
					
			model.addAttribute("generaluser",generaluser);
			System.out.println("generaluser saved successfully");
		        mm.sendMail("Scheduler App", "Your Activation Link is http://localhost:8080/Scheduler/generaluser/verify/"+userId+"/"+token,to);
			//model.addAttribute("client", new Client());
		} else
		{
			model.addAttribute("result","fail");
		}
		return "generaluser/userdashboard";
	}
	// Author - Sanket Patel
		// Usage - uses the user id and token from the link to verify the correct user
		@RequestMapping(value = "/verify/{userId}/{token}", method = RequestMethod.GET)
		public String verifyUser(@PathVariable("userId") int userId,
				@PathVariable("token") String tokenFromURL, Model model) {
			
			String tokenFromDB = generaluserService.getUserToken(userId);
			// select token from client where clientId=client_id;
			
			if(tokenFromDB.equals(tokenFromURL)) {
				int result = generaluserService.verifyUser(userId);
				// update client set emailVerified=1 where clientId=client_id
				model.addAttribute("result", "Thank you for verifying the email address");
			} else {
				model.addAttribute("result", "Sorry, verification failed");
			}
			
			return "generaluser/verifyUser";

		}

}
