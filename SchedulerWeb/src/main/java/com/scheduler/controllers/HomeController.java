package com.scheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("home")
@Controller
public class HomeController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String showHomePage() {
		return "home/index";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String showLoginSelectPage() {
		return "home/signin_select";
	}
}
