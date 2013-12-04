package com.scheduler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Campus;
import com.scheduler.models.Roles;
import com.scheduler.services.RolesService;

@RequestMapping("/roles")
@Controller
public class RolesController extends SessionController {
	protected static final String JSON_CONTENT = "application/json";

	@Autowired(required = true)
	private RolesService rolesService;
	
	@RequestMapping(value = "/view" , method = RequestMethod.GET)
	public String viewRoles(Model model)
	{
		addUserModel(model);
		List<Roles> roles = rolesService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("newRole", new Roles());
		return "roles/view";
	}
	
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public String saveRoles(@ModelAttribute("role") Roles role,	Model model)
	{
	
		role.setClientId(Integer.parseInt(sessionMap.get("id")));
		int i = rolesService.saveRole(role);
		return "redirect:../roles/view";
	}
	
	@RequestMapping(value = "/edit/{roleId}" , method = RequestMethod.GET)
	public String editRoles(@PathVariable("roleId") int roleId,	Model model)
	{
		addUserModel(model);
		Roles role = rolesService.getRoleByRoleId(roleId);
		model.addAttribute("Id",role.getRoleId());
		model.addAttribute("role", role);
		return "roles/edit";
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String updateRoles(@ModelAttribute("role") Roles role,	Model model)
	{
		
		role.setClientId(Integer.parseInt(sessionMap.get("id")));
		int i = rolesService.updateRole(role);
		return "redirect:../roles/view";
	}
	
	@RequestMapping(value = "/delete/{roleId}" , method = RequestMethod.GET)
	public String updateRoles(@PathVariable("roleId") int roleId,	Model model)
	{
		int i = rolesService.deleteRole(roleId);
		return "redirect:../../roles/view";
	}
}
