package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Department;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Timeslot;

/*
 * Author - Sonny
 * Use - Declares all functionalities related to time slots
 */

@Repository(value="timeslotMapper")
@Component
public interface TimeslotMapper {
	
	int addNewTimeslot(Timeslot timeslot);
	
	Timeslot getTimeslotDetails(@Param("timeslotId") int timeslotId);
	
	List<Timeslot> getAllTimeslots(@Param("clientId") int clientId);

	List<Departmenttimeslot> getDepartmentsByTimeslot(@Param("timeslotId") int timeslotId);
	
	int removeTimeslot(@Param("timeslotId") int timeslotId);
	
	int updateTimeslot(Timeslot timeslot);
	
	Timeslot getDuplicate(Timeslot timeslot);
	
	
}
