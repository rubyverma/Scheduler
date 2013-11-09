package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Timeslot;

@Repository(value="timeslotMapper")
@Component
public interface TimeslotMapper {

	/*
	 * Author - Sonny
	 * Use - Declares all functionalities related to time slots
	 */
	
	List<Timeslot> getAllTimeslots(@Param("client_id") int client_id);
	
	int addNewTimeslot(Timeslot timeslot);
	
	int removeTimeslot(@Param("timeslot_id") int timeslot_id);
}
