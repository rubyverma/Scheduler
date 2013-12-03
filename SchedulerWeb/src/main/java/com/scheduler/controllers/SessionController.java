package com.scheduler.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.scheduler.services.SessionService;

public abstract class SessionController {

	@Autowired
	public SessionService sessionService;

	protected Map<String, String> sessionMap;

	protected void addUserModel(Model model) {
		sessionMap = new HashMap<String, String>();
		
		if (sessionService.userType.equals("CL")) {
			sessionMap.put("id", Integer.toString(sessionService.client.getClientId()));
			sessionMap.put("name", sessionService.client.getClientName());
			sessionMap.put("email", sessionService.client.getEmail());
		} else if (sessionService.userType.equals("OU")) {
			sessionMap.put("id", Integer.toString(sessionService.officialUser.getOfficialId()));
			sessionMap.put("name", sessionService.officialUser.getOfficialName());
			sessionMap.put("email", sessionService.officialUser.getEmail());
			sessionMap.put("deptId",Integer.toString(sessionService.officialUser.getDepartmentId()));
		} else {
			sessionMap.put("id", Integer.toString(sessionService.generalUser.getUserId()));
			sessionMap.put("name", sessionService.generalUser.getFirstName() + " " + sessionService.generalUser.getLastName());
			sessionMap.put("email", sessionService.generalUser.getEmail());
		}
		sessionMap.put("role", sessionService.userType);
		model.addAttribute("user", sessionMap);
	}
}
