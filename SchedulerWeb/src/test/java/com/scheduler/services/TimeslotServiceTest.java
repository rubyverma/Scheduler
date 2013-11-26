package com.scheduler.services;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Timeslot;

public class TimeslotServiceTest extends BaseTest {

	@Autowired(required = true)
	private TimeslotService timeslotService;

	@Test
	public void testCreateNewTimeslot() {

		Timeslot newTimeslot = new Timeslot();
		newTimeslot.setClientId(1);
		newTimeslot.setStartTime(Time.valueOf("09:00:00"));
		newTimeslot.setStopTime(Time.valueOf("13:00:00"));
		newTimeslot.setDescription("New timeslot");

		int newTimeslotId = timeslotService.CreateNewTimeslot(newTimeslot);
		assertTrue("Failed to create timeslot", newTimeslotId > 0);

	}
	
	@Test
	public void testGetTimeslotDetails() {
		
		// get details of the timeslot
		Timeslot timeslotFromDB = timeslotService.GetTimeslotDetails(1);
		String actualDescription = timeslotFromDB.getDescription();
		String expectedDescription = "New timeslot";

		assertEquals(actualDescription, expectedDescription);

	}
	
	@Test
	public void testRemoveTimeslot() {

		int timeslotId = 13; // replace with a timeslotId already exist in database
		// Removing the timeslot
		Boolean actualResult = timeslotService.RemoveTimeslot(timeslotId); 
		Boolean expectedResult = true;

		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testUpdateTimeslot() {

		// enter a timeslotId that already exists in db
		int timeslotId = 15;
		
		Timeslot updateTimeslot = new Timeslot();
		updateTimeslot.setTimeslotId(15);
		updateTimeslot.setClientId(1);
		updateTimeslot.setStartTime(Time.valueOf("10:00:00"));
		updateTimeslot.setStopTime(Time.valueOf("16:00:00"));
		updateTimeslot.setDescription("Timeslot updated");

		boolean actualUpdatedStatus = timeslotService
				.UpdateTimeslot(updateTimeslot);
		boolean expectedUpdatedStatus = true;
		assertEquals(actualUpdatedStatus, expectedUpdatedStatus);

		Timeslot timeslotFromDB = timeslotService.GetTimeslotDetails(15);
		String actualDescription = timeslotFromDB.getDescription();
		String expectedDescription = "Timeslot updated";

		assertEquals(actualDescription, expectedDescription);

	}
	
}
