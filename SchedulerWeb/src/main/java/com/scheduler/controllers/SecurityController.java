package com.scheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("security")
@Controller
public class SecurityController {
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
        //return "redirect:/list";
        return "home/index";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map, RedirectAttributes ra) {
    	
        return "redirect:generaluser/dashboard";
    }
  
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "home/login";
    	//return "home/signin_select";
    }
 
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "home/denied";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "home/logout";
    }
}