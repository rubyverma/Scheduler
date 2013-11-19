package com.scheduler.controllers;

import javax.servlet.http.HttpSession;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;
import com.scheduler.request.MailMail;
import com.scheduler.services.ClientService;

@RequestMapping("/client")
@Controller
public class ClientController {

	@Autowired(required = true)
	private ClientService clientService;

	/*
	 * @Autowired private MailSender mailSender;
	 * 
	 * @Autowired private SimpleMailMessage preConfiguredMessage;
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("client", new Client());
		return "client/registerclient";
	}

	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client, Model model)
	{
		String token = null;
		int cId;
		if (client!=null)
		{
			String to = client.getEmail().toString();
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			Random randomGenerator = new Random();
			int mytoken =randomGenerator.nextInt(999999-100000)+100000;
			client.setToken(""+mytoken);
			int result = clientService.saveClient(client);

			model.addAttribute("client", client);
			System.out.println("client saved successfully");
			mm.sendMail("Scheduler App",
					"This is a Test Email \n your activation code : " + token,
					to);
			// model.addAttribute("client", new Client());
		} else {
			model.addAttribute("result", "fail");
		}
		return "client/clientdashboard";
	}

	// Author - Devraj Valecha
	// Usage - uses the client id and token from the link to verify the correct
	// client
	@RequestMapping(value = "/verify/{client_id}/{token}", method = RequestMethod.GET)
	public String verifyClient(@PathVariable("client_id") int client_id,
			@PathVariable("token") String tokenFromURL, Model model) {

		String tokenFromDB = clientService.getClientToken(client_id);
		// select token from client where clientId=client_id;

		if (tokenFromDB.equals(tokenFromURL)) {
			int result = clientService.verifyClient(client_id);
			// update client set emailVerified=1 where clientId=client_id
			model.addAttribute("result",
					"Thank you for verifying the email address");
		} else {
			model.addAttribute("result", "Sorry, verification failed");
		}

		return "client/verifyClient";

	}

	// Author - Devraj Valecha
		// Usage - Login for client
		// client
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginClient(Model model)
	{
		return "client/loginclient";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticateClient(@RequestParam("userName") String userName,
			@RequestParam("password") String password, Model model,
			HttpSession session) {
		Client c1 = new Client();
		c1.setUserName(userName);
		c1.setPassword(password);
		Client result = clientService.authenticate(c1);
		if (result.getClientId()>0) {
			String name = result.getClientName();
			int id = result.getClientId();
			session.setAttribute("clientUserName", userName);
			session.setAttribute("clientName", name);
			session.setAttribute("clientId", id);
		} else {
			model.addAttribute("result", "Login Failed");
			return "client/errorclientlogin";
		}
		return "redirect:dashboard";
	}
	

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String showDashboard(Model model)
	{
		return "client/dashboard";
	}
	
	// Author - Devraj Valecha
			// Usage - Reset password for client
			// client
		@RequestMapping(value = "/reset", method = RequestMethod.GET)
		public String resetPasswordClient(Model model)
		{
			return "client/resetpasswordclient";
		}
		@RequestMapping(value = "/saveTemporaryPassword", method = RequestMethod.POST)
		public String savePassword(@RequestParam("emailAddress") String email,Model model)
		{
			
			Random randomGenerator = new Random();
			String myPassword =Integer.toString(randomGenerator.nextInt(20000));
			int passwordUpdate = clientService.resetPassword(email,myPassword);
			if(passwordUpdate>0)
			{
				String to = email;
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
				MailMail mm = (MailMail) context.getBean("mailMail");
				String url = "http://localhost:8080/Scheduler/client/login";
				mm.sendMail("Scheduler App",
						"This is a Test Email \n your temporary password : " + myPassword + 
						 " \n Below is the link provided to login to scheduler\n" + url,
						to);
			}
			else
			{
				return "client/passworderrorclient";
			}
			
			return"client/passwordsent";
		}
		
}