package com.scheduler.controllers;

import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Category;
import com.scheduler.models.Client;
import com.scheduler.models.Faq;
import com.scheduler.models.DepartmentStatistics;
import com.scheduler.request.MailMail;
import com.scheduler.services.AppointmentService;
import com.scheduler.services.CampusService;
import com.scheduler.services.ClientService;
import com.scheduler.services.DepartmentService;

@RequestMapping("/client")
@Controller
public class ClientController extends SessionController {

	@Autowired(required = true)
	private ClientService clientService;

	@Autowired(required = true)
	private CampusService campusService;
	
	@Autowired(required = true)
	private DepartmentService departmentService;
	
	@Autowired(required = true)
	private AppointmentService appointmentService;
	
	/*
	 * @Autowired private MailSender mailSender;
	 * 
	 * @Autowired private SimpleMailMessage preConfiguredMessage;
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showClientDashboard(Model model) {
		addUserModel(model);
		return "client/dashboard";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("client", new Client());
		return "client/registerclient";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client,
			Model model) {
		int cId;
		String clientname="";
		if (client != null) {
			String to = client.getEmail().toString();
			
			clientname=client.getUserName();
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			Random randomGenerator = new Random();
			int mytoken = randomGenerator.nextInt(999999 - 100000) + 100000;
			client.setToken("" + mytoken);
			int result = clientService.saveClient(client);
			model.addAttribute("client", client);
			System.out.println("client saved successfully");
			cId=clientService.getClientId(to);
			mm.sendMail(" "+clientname,
					"Your Activation Link is http://localhost:8080/Scheduler/client/verify/"
							+ cId + "/" + mytoken, to);
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
	public String loginClient(Model model) {
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
		if (result.getClientId() > 0) {
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
	public String showDashboard(Model model) {
		addUserModel(model);
		int clientId = Integer.parseInt(sessionMap.get("id"));
		model.addAttribute("campusCount", campusService.findAllCampuses(clientId).size());
		model.addAttribute("departmentCount", departmentService.departmentByClient(clientId).size());
		model.addAttribute("appointmentCount", appointmentService.getAppointmentCountByClientId(clientId));
		return "client/dashboard";
	}

	// Author - Devraj Valecha
	// Usage - Reset password for client
	// client
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String resetPasswordClient(Model model) {
		return "client/resetpasswordclient";
	}

	@RequestMapping(value = "/saveTemporaryPassword", method = RequestMethod.POST)
	public String savePassword(@RequestParam("emailAddress") String email,
			Model model) {

		Random randomGenerator = new Random();
		String myPassword = Integer.toString(randomGenerator.nextInt(20000));
		int passwordUpdate = clientService.resetPassword(email, myPassword);
		if (passwordUpdate > 0) {
			String to = email;
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url = "http://localhost:8080/Scheduler/client/login";
			mm.sendMail(
					"Scheduler App",
					"This is a Test Email \n your temporary password : "
							+ myPassword
							+ " \n Below is the link provided to login to scheduler\n"
							+ url, to);
		} else {
			return "client/passworderrorclient";
		}

		return "client/passwordsent";
	}

	// Author - Devraj Valecha
	// FAQs
	// client

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllFaqCategories(Model model) {
		List<Category> categories = null;

		categories = clientService.findAllCategories();
		model.addAttribute("categories", categories);
		addUserModel(model);
		return "client/faqs";
	}

	@RequestMapping(value = "/viewfaqs/{categoryId}", method = RequestMethod.GET)
	public String viewAllFaqs(@PathVariable("categoryId") int categoryId,
			Model model) {
		List<Faq> fQns = clientService.getFaqQns(categoryId);
		model.addAttribute("fQns", fQns);
		addUserModel(model);
		return "client/faqsqa";

	}

	@RequestMapping(value = "/viewstats", method = RequestMethod.GET)
	public String viewAllStastics(Model model) {

		try {
			List<DepartmentStatistics> departmentStats = clientService
					.getStatistics();
			model.addAttribute("departmentStatistics", departmentStats);

		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		addUserModel(model);
		return "client/viewstats";
	}

	// Author - Shalin Banjara
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editClient(Model model) {
		addUserModel(model);
		int clientId = Integer.parseInt(sessionMap.get("id"));
		model.addAttribute("clientId", clientId);
		model.addAttribute("client", clientService.getClientById(clientId));
		// System.out.println(clientService.getClientById(clientId).getLogo());
		
		return "client/editclient";
	}

	// Author - Shalin Banjara
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateClient(@ModelAttribute("client") Client client,
			Model model) {
		int i = clientService.updateClientById(client);
		System.out.println(client.getLogo());
		addUserModel(model);
		return "client/dashboard";
	}

	// Author - Shalin Banjara
	@RequestMapping(value = "/editpassword", method = RequestMethod.GET)
	public String editClientPassword(Model model) {
		addUserModel(model);
		int clientId = Integer.parseInt(sessionMap.get("id"));
		model.addAttribute("password", clientService.getClientById(clientId)
				.getPassword());
		model.addAttribute("clientId", clientId);
		model.addAttribute("client", new Client());
		// System.out.println(clientService.getClientById(clientId).getLogo());
		addUserModel(model);
		return "client/editclientpassword";
	}

	// Author - Shalin Banjara
	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public String updateClientPassword(@ModelAttribute("client") Client client,
			Model model) {
		System.out.println(client.getClientId());
		System.out.println(client.getPassword());
		int i = clientService.updateClientPasswordById(client);
		addUserModel(model);
		return "client/dashboard";
	}

}