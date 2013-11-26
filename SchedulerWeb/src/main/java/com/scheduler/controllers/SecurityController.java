package com.scheduler.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;
import com.scheduler.services.SecurityService;
import com.scheduler.services.SessionService;
 
@Controller
public class SecurityController {
 
	@Autowired
	public SecurityService securityService;
	
		@Autowired
		public SessionService sessionService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
    	return "home/index";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String loginRedirect(ModelMap map) {
    	
    	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println(user.getAuthorities().toString());
    	String useremail = user.getUsername().toString();
    	
    	if(user.getAuthorities().contains(new SimpleGrantedAuthority("CL"))) {
    		Client client = securityService.getClientByEmail(useremail);
    		sessionService.userType = "CL";
    		sessionService.client = client;
    		return "redirect:client/dashboard";
    	} else if(user.getAuthorities().contains(new SimpleGrantedAuthority("OU"))) {
    		OfficialUser officialuser = securityService.getOfficialByEmail(useremail);
    		sessionService.userType = "OU";
    		sessionService.officialUser = officialuser;
    		return "redirect:official/dashboard";
    	} else if(user.getAuthorities().contains(new SimpleGrantedAuthority("GU"))) {
    		GeneralUser generaluser = securityService.getUserByEmail(useremail);
    		sessionService.userType = "GU";
    		sessionService.generalUser = generaluser;
    		return "redirect:generaluser/dashboard";
    	}
        return "home/home";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
 
    	if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
    		return "redirect:list";
    	}
        return "home/login";
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