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
	
	 public List<Department> departmentByClient(@Param("clientId") int clientId )  throws BadSqlGrammarException {
         List<Department> departments = new ArrayList<Department>();
         departments = departmentMapper.getDepartmentByClient(clientId);
         return departments;
 }
	
	public int deleteDepartment(int departmentId) throws BadSqlGrammarException {
		return departmentMapper.deleteDepartment(departmentId); 
	}
	
	public int saveDepartment(Department department) throws BadSqlGrammarException {
		return departmentMapper.saveDepartment(department);
	}

	public int updateDepartment(Department department) throws BadSqlGrammarException {
		return departmentMapper.updateDepartment(department);
	}
	
	public Department getDepartmentById(int departmentId) throws BadSqlGrammarException {
		return departmentMapper.getDepartmentById(departmentId);
	}
	
	public int validateDepartment(Department department) throws BadSqlGrammarException {
		return departmentMapper.validateDepartment(department);
	}

}
