	package com.scheduler.controllers;
	
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.scheduler.models.Campus;
import com.scheduler.models.Department;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.OfficialUser;
import com.scheduler.models.Timeslot;
import com.scheduler.services.CampusService;
import com.scheduler.services.DepartmentService;
import com.scheduler.services.DepartmentTimeslotService;
import com.scheduler.services.OfficialUserService;
import com.scheduler.services.TimeslotService;
	
	@RequestMapping("/department")
	@Controller
	@Slf4j
	public class DepartmentController {
	
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
			List<Campus> campuses = campusService.findAllCampuses(1);
			List<Timeslot> timeslots = timeslotService.GetAllTimeslots(1);			
			
			Department dept = new Department();
			model.addAttribute("department", dept);
			model.addAttribute("campuses", campuses);
			model.addAttribute("timeslots", timeslots);
			return "department/edit";
		}
	
		@RequestMapping(value = "/edit/{departmentId}", method = RequestMethod.GET)
		public String editNewDepartment(@PathVariable("departmentId") int departmentId, Model model) {
			List<Campus> campuses = campusService.findAllCampuses(1);
			List<Timeslot> timeslots = timeslotService.GetAllTimeslots(1);
			Department dept = departmentService.getDepartmentById(departmentId);
			List<Departmenttimeslot> slots = departmentTimeslotService.getDepartmentTimeslot(departmentId);
			
			List<String> days = new ArrayList<String>();
			for (int index = 0; index < slots.size(); index++) {
				Departmenttimeslot sl = slots.get(index);				
				char [] selectedDays = sl.getWeekdays().toCharArray();
				int i = 1;
				for (char c : selectedDays) {
					if(c == '1') {
						String sd = sl.getTimeslotId() + ",";
						sd = sd + i;
						days.add(sd);
					}
					i++;
				}
			}

			dept.setCapacity(slots.get(0).getCapacity());
		
			dept.setDays(days);
			model.addAttribute("campuses", campuses);
			model.addAttribute("timeslots", timeslots);
			model.addAttribute("forEdit", true);
			model.addAttribute("department", dept);
			return "department/edit";
		}
		
		// Author - Ruby Verma
		// Usage - Adds and save new department
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveDepartment(@ModelAttribute("department") Department department, Model model) {
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
			
			if(department.getDays() != null) {
				Map<String, String> selectedDays = new HashMap<String, String>();
				for (int j = 0; j < department.getDays().size(); j++) {
					final String[] day = (department.getDays().get(j)).split(",");
					String key = day[0];
					String value = day[1];
					if(selectedDays.containsKey(key)) {
						value = selectedDays.get(key) + "," + value;
					}
					selectedDays.put(key, value);
				}
				
				Iterator it = selectedDays.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> current = (Map.Entry<String, String>) it.next();
					
					Boolean [] days = new Boolean[7];
					days[0] = false;
					days[1] = false;
					days[2] = false;
					days[3] = false;
					days[4] = false;
					days[5] = false;
					days[6] = false;
					
					String [] daysValue = current.getValue().split(",");
					for (int j = 0; j < daysValue.length; j++) {
						days[Integer.parseInt(daysValue[j]) - 1] = true;
					}
					
					String d = "";
					for (Boolean b : days) {
						if(b) {
							d = d + "1";
						} else {
							d = d + "0";
						}
					}
					System.out.println(current.getKey());
					System.out.println(d);
					System.out.println("---");
					Departmenttimeslot slot = new Departmenttimeslot();
					slot.setWeekdays(d);
					slot.setDepartmentId(deptId);
					slot.setCapacity(department.getCapacity());
					slot.setTimeslotId(Integer.parseInt(current.getKey()));
					departmentTimeslotService.saveDepartmentTimeslot(slot);
				}				
			}

			
			return "redirect:/official/users/view";
		}
				
	}