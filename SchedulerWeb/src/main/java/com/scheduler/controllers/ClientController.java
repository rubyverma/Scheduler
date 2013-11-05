package com.scheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Client;
import com.scheduler.request.MailMail;
import com.scheduler.services.ClientService;


@RequestMapping("/client")
@Controller

public class ClientController {

	@Autowired(required=true)
	private ClientService clientService;
	
	/*@Autowired
    private MailSender mailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
 */
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("client", new Client());
		return "client/registerclient";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client, Model model)
	{
		if (client!=null)
		{
			String to = client.getEmail().toString();
			String token = "123456789";
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			int result = clientService.saveClient(client);
			model.addAttribute("client",client);
			System.out.println("client saved successfully");
		        mm.sendMail("Scheduler App", "This is a Test Email \n your activation code : " + token,to);
			//model.addAttribute("client", new Client());
		} else
		{
			model.addAttribute("result","fail");
		}
		return "client/clientdashboard";
	}

}
