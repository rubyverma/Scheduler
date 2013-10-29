package com.scheduler.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scheduler.models.Department;
import com.scheduler.services.CampusService;
import com.scheduler.services.DepartmentService;

@RequestMapping("/department")
@Controller
@Slf4j
public class DepartmentController {
	
	@Autowired(required = true)
	private DepartmentService departmentService;

	@RequestMapping(value = "/getDepartmentCombo/{campusId}", method = RequestMethod.GET)
	public String getDepartmentByCampus(@PathVariable("campusId") int campusId, Model model) {
		log.info("Entered Controller");
		List<Department> departments = departmentService.departmentByCampus(campusId);
		log.info("Got Department List");
		model.addAttribute("departments", departments);
		return "partials/departmentcombo";
	}
}
