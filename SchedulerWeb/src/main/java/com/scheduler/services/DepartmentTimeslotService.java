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
import com.scheduler.models.Utility;

@Component
public class DepartmentTimeslotService {

	@Autowired(required = true)
	private DepartmentTimeslotMapper departmentTimeslotMapper;
	
	public List<DepartmentTimeslotLinkage> timeslotByDepartment(Utility u)  throws BadSqlGrammarException {
		List<DepartmentTimeslotLinkage> departmenttimeslots = new ArrayList<DepartmentTimeslotLinkage>();
		departmenttimeslots = departmentTimeslotMapper.getTimeslotByDepartment(u);
		for (DepartmentTimeslotLinkage depTime:departmenttimeslots ) {
			Date d = Date.valueOf(u.getAppointmentDate());
			depTime.setAppointmentDate(d);
			System.out.println(depTime.getDepartmentTimeId());
		}
		return departmenttimeslots;
	}
}
