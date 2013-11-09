package com.scheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.TimeslotMapper;
import com.scheduler.models.Departmenttimeslot;
import com.scheduler.models.Timeslot;

/*
 * Author - Sonny
 * Use - Implementation of all timeslot functionalities
 */

@Component
public class TimeslotService {

	@Autowired(required = true)
	private TimeslotMapper timeslotMapper;
	
	// Fetch the list of all timeslots created for that particular client
	public List<Timeslot> GetAllTimeslots(int clientId) {
		
		return timeslotMapper.getAllTimeslots(clientId);
		
	}
	
	// returns a boolean value which shows whether the timeslot passed in is successfully-
	// added to the database
	public boolean CreateNewTimeslot(Timeslot newTimeslot) {
		
		int rowsAffected = timeslotMapper.addNewTimeslot(newTimeslot);
		
		if(rowsAffected > 0) {
			return true;
		}
		
		return false;
		
	}
	
	// fetches the full details of the timeslot whose id is passed in
	public Timeslot GetTimeslotDetails(int timeslotId) {
		
		return timeslotMapper.getTimeslotDetails(timeslotId);
		
	}
	
	// removes a timeslot from the database
	// detailed logic specified inside the function
	public boolean RemoveTimeslot(int timeslotId) {
		
		// if the timeslot is used by some department, it cannot be deleted
		List<Departmenttimeslot> departments = timeslotMapper.getDepartmentsByTimeslot(timeslotId);
		
		if(departments.size() > 0) {
			// means there is one or more departments currently using this timeslot
			// so restrict user from deleting it
			return false;
		} else {
			// means no department is currently using this timeslot and it is safe to delete
			// perform delete operation
			int rowsAffected = timeslotMapper.removeTimeslot(timeslotId);
			if(rowsAffected >= 0) {
				return true;
			} else {
				return false;
			}
		}

	}
}
