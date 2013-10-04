package com.scheduler.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.scheduler.models.User;
import com.scheduler.services.UserService;

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {
	
	@Autowired(required = true)
	private UserService userService; 
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("user", new User());
		return "user/registeruser";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		if(user != null)
		{
			int result = userService.saveUser(user);
			model.addAttribute("result", result);
		}
		else
			model.addAttribute("result", "fail");
		
		List<User> users;
		try
		{
			users = userService.findAllUsers();
			model.addAttribute("users", users);
		} catch (BadSqlGrammarException e)
		{
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		return "user/viewusers";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {
		
		List<User> users;
		try
		{
			users = userService.findAllUsers();
			model.addAttribute("users", users);

		} catch (BadSqlGrammarException e)
		{
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		return "user/viewusers";
	}
	
	@RequestMapping(value = "details/{user_id}", method = RequestMethod.GET)
	public String userDetails(@PathVariable("user_id") int user_id, Model model) { 
		
		User user;

		try
		{
			user = userService.findUserById(user_id);
			model.addAttribute("user", user);

		} catch (BadSqlGrammarException e)
		{
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}		
		
		return "user/userdetails";
	}
	
	@RequestMapping(value = "delete/{user_id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("user_id") int user_id, RedirectAttributes ra, Model model) { 
		
		
		int result = userService.deleteUser(user_id);
		
		try
		{
			result = userService.deleteUser(user_id);
			model.addAttribute("result", result);
		} catch (BadSqlGrammarException e)
		{
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}		
			
		return "redirect:/user/view";
	}
	
}
