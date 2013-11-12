package com.scheduler.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;
import com.scheduler.services.GeneralUserService;
@RequestMapping("/generaluser")
@Controller
public class GeneralUserController {
	@Autowired(required = true)
	private GeneralUserService generalUserService;
	// Author - Devraj Valecha
				// Usage - Login for general user
				// general user
			@RequestMapping(value = "/login", method = RequestMethod.GET)
			public String loginGeneralUser(Model model)
			{
				return "generaluser/logingeneraluser";
			}
			
			@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
			public String authenticateGeneralUser(@RequestParam("userName") String userName,
					@RequestParam("password") String password, Model model,
					HttpSession session) {
				GeneralUser gu = new GeneralUser();
				gu.setUsername(userName);;
				gu.setPassword(password);
				GeneralUser result = generalUserService.authenticate(gu);
				if (result.getUserId()>0) {
					String name = result.getFirstName();
					int id = result.getUserId();
					session.setAttribute("generalUserName", userName);
					session.setAttribute("generalName", name);
					session.setAttribute("generalId", id);
				} else {
					model.addAttribute("result", "Login Failed");
					return "generaluser/errorgenerallogin";
				}
				return "redirect:dashboard";
			}
			

			@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
			public String showDashboard(Model model)
			{
				return "generaluser/dashboard";
			}
			
}
