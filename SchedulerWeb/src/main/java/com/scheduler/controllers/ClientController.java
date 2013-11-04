package com.scheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Client;
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
			int result = clientService.saveClient(client);
			model.addAttribute("client",client);
			System.out.println("client saved successfully");
		} else
		{
			model.addAttribute("result","fail");
		}
		return "client/sendActivation";
	}
	
	@RequestMapping(value="/sendActivation", method=RequestMethod.GET)
	public String sendActivationEmail(@ModelAttribute("client") Client client, Model model)
	{
		  // Recipient's email ID needs to be mentioned.	
	      String to = client.getEmail().toString();

	      /*// Activation Token
	      String token= client.getToken().toString();

	    	  SimpleMailMessage message = new SimpleMailMessage(preConfiguredMessage);
	          message.setTo(to);
	          message.setText(token);
	          mailSender.send(message);
	         System.out.println("email sent successfully....");
		

		model.addAttribute("client", new Client());*/
		return "client/registerclient";
	}

}
