package com.scheduler.controllers;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import lombok.extern.slf4j.Slf4j;
 
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.scheduler.models.Appointment;
import com.scheduler.models.Campus;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Utility;
import com.scheduler.services.AppointmentService;
import com.scheduler.services.CampusService;
import com.scheduler.services.DepartmentService;
import com.scheduler.services.DepartmentTimeslotService;
 
@RequestMapping("/api")
@Controller
@Slf4j
public class RestController {
 
    protected static final String JSON_CONTENT = "application/json";
    
    @Autowired(required = true)
    private CampusService campusService;
    @Autowired(required = true)
    private DepartmentService departmentService;
    @Autowired(required = true)
    private DepartmentTimeslotService departmentTimeslotService;
	@Autowired(required = true)
	private AppointmentService appointmentService;
       
    
    @RequestMapping(value = "/getCampusByClient/{id}", method = RequestMethod.GET, produces = JSON_CONTENT)
    @ResponseBody
    public List<Campus> getCampusByClient(@PathVariable int id) {
    	List<Campus> campuses = campusService.campusByClient(id);
        return campuses;
    }
    
    @RequestMapping(value = "/getDepartmentByCampus/{id}", method = RequestMethod.GET, produces = JSON_CONTENT)
    @ResponseBody
    public List<Department> getDepartmentByCampus(@PathVariable int id) {
    	List<Department> departments = departmentService.departmentByCampus(id);
        return departments;
    }
    
    @RequestMapping(value = "/getDepartmentTimeslot/{id}/{dt}", method = RequestMethod.GET, produces = JSON_CONTENT)
    @ResponseBody
    public List<DepartmentTimeslotLinkage> getDepartmentTimeslot(@PathVariable int id, @PathVariable String dt) throws java.text.ParseException, ParseException {
		Utility u = new Utility(id, dt);
		System.out.println(u.getDepartmentId() + " - "+ u.getAppointmentDate());
		List<DepartmentTimeslotLinkage> availableTimeslots = departmentTimeslotService.timeslotByDepartment(u);
    	return availableTimeslots;
    }
    
    @RequestMapping(value = "/saveappointment", method = RequestMethod.POST, produces = JSON_CONTENT)
    @ResponseBody
    public Map<String, String> saveAppointment(@RequestBody Appointment appointment) {
    	int i = -1;
		try {
			i = appointmentService.saveAppointment(appointment);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		Map<String, String> result = new HashMap<String, String>();
		if(i == -1) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
    	return result;
    }    
}