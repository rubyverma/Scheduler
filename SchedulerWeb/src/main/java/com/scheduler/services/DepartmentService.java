package com.scheduler.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import com.scheduler.mappers.DepartmentMapper;
import com.scheduler.models.Department;

@Component
public class DepartmentService {
	
	@Autowired(required = true)
	private DepartmentMapper departmentMapper;
	
	public List<Department> departmentByCampus(@Param("campusId") int campusId )  throws BadSqlGrammarException {
		List<Department> departments = new ArrayList<Department>();
		departments = departmentMapper.getDepartmentByCampus(campusId);
		return departments;
	}

}
