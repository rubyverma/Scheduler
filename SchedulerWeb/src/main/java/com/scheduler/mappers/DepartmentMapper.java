package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Department;

@Repository(value="departmentMapper")
@Component
public interface DepartmentMapper {
	
	List<Department> getDepartmentByCampus(@Param("campusId") int campusId);
	
	 List<Department> getDepartmentByClient(@Param("clientId") int clientId);

	int deleteDepartment(int departmentId) throws BadSqlGrammarException;
	
	int saveDepartment(Department department) throws BadSqlGrammarException;

	int updateDepartment(Department department) throws BadSqlGrammarException;
	
	Department getDepartmentById(int departmentId) throws BadSqlGrammarException;
	
	int validateDepartment(Department department) throws BadSqlGrammarException;

}
