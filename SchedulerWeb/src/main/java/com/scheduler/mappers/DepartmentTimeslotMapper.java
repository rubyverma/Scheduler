package com.scheduler.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Utility;

@Repository(value="departmentTimeslotMapper")
@Component
public interface DepartmentTimeslotMapper {
	
	List<DepartmentTimeslotLinkage> getTimeslotByDepartment(Utility u);
	
	int saveDepartmentTimeslot(Departmenttimeslot slot) throws BadSqlGrammarException;

}
