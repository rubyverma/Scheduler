package com.scheduler.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.User;
import com.scheduler.request.CommonResponse;
import com.scheduler.services.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	protected static final String JSON_CONTENT = "application/json";

	@Autowired(required = true)
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {

		model.addAttribute("user", new User());
		return "user/registeruser";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		if (user != null) {
			int result = userService.saveUser(user);
			model.addAttribute("result", result);
		} else
			model.addAttribute("result", "fail");

		List<User> users;
		try {
			users = userService.findAllUsers();
			model.addAttribute("users", users);
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		return "user/viewusers";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {

		List<User> users;
		try {
			users = userService.findAllUsers();
			model.addAttribute("users", users);

		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		return "user/viewusers";
	}

	@RequestMapping(value = "details/{user_id}", method = RequestMethod.GET)
	public String userDetails(@PathVariable("user_id") int user_id, Model model) {

		User user;

		try {
			user = userService.findUserById(user_id);
			model.addAttribute("user", user);

		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}

		return "user/userdetails";
	}

	@RequestMapping(value = "delete/{user_id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("user_id") int user_id,
			RedirectAttributes ra, Model model) {

		int result;

		try {
			result = userService.deleteUser(user_id);
			model.addAttribute("result", result);
		} catch (BadSqlGrammarException e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}

		return "redirect:/user/view";
	}

	@RequestMapping(value = "nickname/", method = RequestMethod.POST)
	public String getNickname(HttpServletRequest req, Model model) {

		String user_id = req.getParameter("user_id");

		String nickname_msg = "abc of " + user_id;

		List<User> nickNameList = new ArrayList<User>();
		nickNameList.add(new User(10, "skr@gm.com", nickname_msg, "rju"));
		nickNameList.add(new User(11, "skr@gm.com", "abc", "def"));

		// name = userService.getNickName(user_id);
		model.addAttribute("nickname", nickNameList);

		return "/partials/nicknamecombo";
	}

	/* JSON CODE */
	
	@RequestMapping(value = "/api/get/{id}", method = RequestMethod.GET, produces = JSON_CONTENT)
	@ResponseBody
	public User testGet(@PathVariable int id) {
		
		final User u = new User();
		u.setFirstname("John");
		u.setLastname("Doe");
		u.setEmail("john@gmail.com");
		u.setId(id);
		return u;
		
	}

	@RequestMapping(value = "/api/save", method = RequestMethod.POST, produces = JSON_CONTENT)
	@ResponseBody
	public User testPost(@RequestBody final User request) {

		final User u = request;
		/*
		CommonResponse response = new CommonResponse();
		response.setResponseCode(200); // 200 means success
		response.setResponseMessage("Received " + u.getFirstname());
		*/
		return u;

	}

}
