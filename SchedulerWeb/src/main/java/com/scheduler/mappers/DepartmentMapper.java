package com.scheduler.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.scheduler.models.Department;

@Repository(value="departmentMapper")
@Component
public interface DepartmentMapper {
	
	List<Department> getDepartmentByCampus(@Param("campusId") int campusId);
}
