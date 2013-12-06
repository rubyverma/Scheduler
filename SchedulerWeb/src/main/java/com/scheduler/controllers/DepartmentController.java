	package com.scheduler.controllers;
	
	import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.Campus;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentStatistics;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Timeslot;
import com.scheduler.services.CampusService;
import com.scheduler.services.DepartmentService;
import com.scheduler.services.DepartmentTimeslotService;
import com.scheduler.services.OfficialUserService;
import com.scheduler.services.TimeslotService;
	
	@RequestMapping("/department")
	@Controller
	@Slf4j
	public class DepartmentController extends SessionController {
	
		@Autowired(required = true)
		private OfficialUserService officialUserService;
		
		@Autowired(required = true)
		private DepartmentService departmentService;
	
		@Autowired(required = true)
		private DepartmentTimeslotService departmentTimeslotService;
		
		@Autowired(required = true)
		private CampusService campusService;
	
		@Autowired(required = true)
		private TimeslotService timeslotService;
		
		// Author - Shalin Banjara
		// Usage - Returns a combo box with departments related to selected campus.
		@RequestMapping(value = "/getDepartmentCombo/{campusId}", method = RequestMethod.GET)
		public String getDepartmentByCampus(@PathVariable("campusId") int campusId,
				Model model) {
			List<Department> departments = departmentService
					.departmentByCampus(campusId);
			model.addAttribute("departments", departments);
			return "partials/departmentcombo";
		}
		
		// Author - Ruby Verma
		// Usage - Delete selected campus
		@RequestMapping(value = "/delete/{departmentId}", method = RequestMethod.GET)
		public String deleteDepartment(@PathVariable("departmentId") int departmentId,
				RedirectAttributes ra, Model model) {
			int rowsUpdated;
	
			try {
				rowsUpdated = departmentService.deleteDepartment(departmentId);
				model.addAttribute("result", "Deleted: " + rowsUpdated + "department");
	
			} catch (BadSqlGrammarException e) {
				model.addAttribute("error", e.getMessage());
				System.out.println(e.getMessage());
			}
	
			return "redirect:/official/users/view";
		}
	
		@RequestMapping(value = "/new", method = RequestMethod.GET)
		public String createNewDepartment(Model model) {
			addUserModel(model);
			int campusId = Integer.parseInt(sessionMap.get("id"));
			List<Campus> campuses = campusService.findAllCampuses(campusId);
			List<Timeslot> timeslots = timeslotService.GetAllTimeslots(campusId);			
			
			Department dept = new Department();
			model.addAttribute("department", dept);
			model.addAttribute("campuses", campuses);
			model.addAttribute("timeslots", timeslots);
			return "department/edit";
		}
		
		@RequestMapping(value = "/edit/{departmentId}", method = RequestMethod.GET)
		public String editNewDepartment(@PathVariable("departmentId") int departmentId, Model model, HttpServletRequest request) {
			addUserModel(model);
			int campusId = Integer.parseInt(sessionMap.get("id"));
			List<Campus> campuses = campusService.findAllCampuses(campusId);
			List<Timeslot> timeslots = timeslotService.GetAllTimeslots(campusId);
			Department dept = departmentService.getDepartmentById(departmentId);
			List<Departmenttimeslot> slots = departmentTimeslotService.getDepartmentTimeslot(departmentId);
			
			Map<String, String> slotsMap = new HashMap<String, String>();
			for (int index = 0; index < slots.size(); index++) {
				Departmenttimeslot sl = slots.get(index);
				String key = "";
				String value = Integer.toString(sl.getCapacity());
				if(sl.getWeekdays().equals(Departmenttimeslot.DAY_1)) {
					key = sl.getTimeslotId() + ",1";					
				} else if(sl.getWeekdays().equals(Departmenttimeslot.DAY_2)) {
					key = sl.getTimeslotId() + ",2";
				} else if(sl.getWeekdays().equals(Departmenttimeslot.DAY_3)) {
					key = sl.getTimeslotId() + ",3";
				} else if(sl.getWeekdays().equals(Departmenttimeslot.DAY_4)) {
					key = sl.getTimeslotId() + ",4";
				} else if(sl.getWeekdays().equals(Departmenttimeslot.DAY_5)) {
					key = sl.getTimeslotId() + ",5";
				}
				slotsMap.put(key, value);
			}
			dept.setSlotsMap(slotsMap);
			
			model.addAttribute("campuses", campuses);
			model.addAttribute("timeslots", timeslots);
			model.addAttribute("forEdit", true);
			model.addAttribute("department", dept);
			
			request.setAttribute("department", dept);
			request.setAttribute("timeslots", timeslots);
			return "department/edit";
		}
		
		// Author - Ruby Verma
		// Usage - Adds and save new department
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveDepartment(@ModelAttribute("department") Department department, Model model,
				HttpServletRequest request) {
			addUserModel(model);
			int clientId = Integer.parseInt(sessionMap.get("id"));
			int i = -1;
			int deptId = -1;
			if(department.getDepartmentId() == 0) {
				 i = departmentService.saveDepartment(department);
				 deptId = departmentService.getSavedDepartmentById();
			} else {
				 i = departmentService.updateDepartment(department);
				 deptId = department.getDepartmentId();
			}
			
			departmentTimeslotService.deleteDepartmentTimeslot(deptId);
			
			List<Timeslot> timeslots = timeslotService.GetAllTimeslots(clientId);
			for (int index = 0; index < timeslots.size(); index++) {
				Timeslot tsl = timeslots.get(index);
				
				for (int j = 1; j <= 5; j++) {
					String key = tsl.getTimeslotId() + "," + j;
					String value = StringUtils.trimAllWhitespace(request.getParameter(key));
					if(value.equalsIgnoreCase("0") || value.equalsIgnoreCase("")) {
						continue;
					}
					Departmenttimeslot slot = new Departmenttimeslot();
					if(j == 1) {
						slot.setWeekdays(Departmenttimeslot.DAY_1);
					} else if(j == 2) {
						slot.setWeekdays(Departmenttimeslot.DAY_2);
					} else if(j == 3) {
						slot.setWeekdays(Departmenttimeslot.DAY_3);
					} else if(j == 4) {
						slot.setWeekdays(Departmenttimeslot.DAY_4);
					} else if(j == 5) {
						slot.setWeekdays(Departmenttimeslot.DAY_5);
					}
					slot.setDepartmentId(deptId);
					slot.setCapacity(Integer.parseInt(value));
					slot.setTimeslotId(tsl.getTimeslotId());
					departmentTimeslotService.saveDepartmentTimeslot(slot);
					System.out.println("saved");
				}
			}
			return "redirect:/official/users/view";
		}
	
		@RequestMapping(value = "/viewstats", method = RequestMethod.GET)
		public String viewAllStastics(Model model) {
		
			try {
				addUserModel(model);
				int departmentID= Integer.parseInt(sessionMap.get("deptId"));
				List<DepartmentStatistics> departmentStats= departmentService.getStatistics(departmentID);
				model.addAttribute("departmentStatistics", departmentStats);
			} catch (BadSqlGrammarException e) {
				model.addAttribute("error", e.getMessage());
				System.out.println(e.getMessage());
			}
			return "department/viewstats";
		}
	}


