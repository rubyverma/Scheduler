package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Department;
import com.scheduler.models.DepartmentStatistics;

@Repository(value="departmentMapper")
@Component
public interface DepartmentMapper {

	List<Department> getDepartmentByCampus(@Param("campusId") int campusId);
	
	List<Department> getDepartmentByClient(@Param("clientId") int clientId);
	
	int deleteDepartment(int departmentID) throws BadSqlGrammarException;
	
	int saveDepartment(Department department) throws BadSqlGrammarException;
	
	int getSavedDepartmentById() throws BadSqlGrammarException;	

	int updateDepartment(Department department) throws BadSqlGrammarException;
	
	Department getDepartmentById(int departmentID) throws BadSqlGrammarException;
	
	int validateDepartment(Department department) throws BadSqlGrammarException;

	List<DepartmentStatistics> getStatistics(int departmentID) throws BadSqlGrammarException;
	

}
