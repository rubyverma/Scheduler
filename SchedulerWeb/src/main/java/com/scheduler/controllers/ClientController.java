package com.scheduler.controllers;

import javax.servlet.http.HttpSession;
import java.util.Random;

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
		String token;
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
			cId= clientService.getLastClientId();
			token= clientService.getClientToken(cId);
			model.addAttribute("client",client);
			System.out.println("client saved successfully");

		    mm.sendMail("Scheduler App", "Your Activation Link is http://localhost:8080/Scheduler/client/verify/"+cId+"/"+token,to);
			//model.addAttribute("client", new Client());
		} else
		{
			model.addAttribute("result","fail");
		}
		return "client/clientdashboard";
	}


}