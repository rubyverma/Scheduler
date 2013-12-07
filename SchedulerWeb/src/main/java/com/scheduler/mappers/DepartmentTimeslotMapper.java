package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Utility;

@Repository(value="departmentTimeslotMapper")
@Component
public interface DepartmentTimeslotMapper {
	
	List<DepartmentTimeslotLinkage> getTimeslotByDepartment(Utility u);
	
	DepartmentTimeslotLinkage getTimeslotByAppointment(@Param("departmentTimeId") int departmentTimeId);
	
	List<Departmenttimeslot> getDepartmentTimeslot(int departmentId) throws BadSqlGrammarException ;
	
	void deleteDepartmentTimeslot(int departmentId);

	int saveDepartmentTimeslot(Departmenttimeslot slot) throws BadSqlGrammarException;
	
	int updateDepartmentTimeslot(Departmenttimeslot slot) throws BadSqlGrammarException;
}
