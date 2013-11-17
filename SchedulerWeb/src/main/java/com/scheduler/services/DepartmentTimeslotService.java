package com.scheduler.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.DepartmentTimeslotMapper;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Utility;

@Component
public class DepartmentTimeslotService {
	
	@Autowired(required = true)
	private DepartmentTimeslotMapper departmentTimeslotMapper;
	// Author - Shalin Banjara
	// Usage - Business logic to calculate the available timeslots for a particular department based on capacity and day of week.
	public List<DepartmentTimeslotLinkage> timeslotByDepartment(Utility u)  throws BadSqlGrammarException {
		List<DepartmentTimeslotLinkage> departmenttimeslots = new ArrayList<DepartmentTimeslotLinkage>();
		List<DepartmentTimeslotLinkage> finalDepartmenttimeslots = new ArrayList<DepartmentTimeslotLinkage>();
		departmenttimeslots = departmentTimeslotMapper.getTimeslotByDepartment(u);
		int i=0;
		if (departmenttimeslots.size()>0)
		{
			for (int j=0;j<departmenttimeslots.size();j++ ) {
				DepartmentTimeslotLinkage depTime = departmenttimeslots.get(j);
				Date d = Date.valueOf(u.getAppointmentDate());
				depTime.setAppointmentDate(d);
				
				//System.out.println(d.getDay());
				String s = depTime.getWeekdays().substring(d.getDay());
				
				if (s.startsWith("1"))
				{
					finalDepartmenttimeslots.add(depTime);
					System.out.println(depTime.toString());
				}
			}
		}
		return finalDepartmenttimeslots;
	}

	public DepartmentTimeslotLinkage getTimeslotByAppointment(@Param("departmentTimeId") int departmentTimeId){
		return departmentTimeslotMapper.getTimeslotByAppointment(departmentTimeId);
	}

	public int saveDepartmentTimeslot(Departmenttimeslot slot) throws BadSqlGrammarException {
		return departmentTimeslotMapper.saveDepartmentTimeslot(slot);
	}

	public int updateDepartmentTimeslot(Departmenttimeslot slot) throws BadSqlGrammarException {
		return departmentTimeslotMapper.updateDepartmentTimeslot(slot);
	}
	
	public List<Departmenttimeslot> getDepartmentTimeslot(int departmentId) throws BadSqlGrammarException  {
		List<Departmenttimeslot> slots = departmentTimeslotMapper.getDepartmentTimeslot(departmentId);
		if(slots != null && slots.size() > 0) {
			for (Departmenttimeslot departmenttimeslot : slots) {
				departmenttimeslot.setWorkingDays(Departmenttimeslot.getWorkingDays(departmenttimeslot.getWeekdays()));
			}			
		}
		return slots;
	}
	
	public void deleteDepartmentTimeslot(int departmentId) {
		departmentTimeslotMapper.deleteDepartmentTimeslot(departmentId);
	}

	
	
}
