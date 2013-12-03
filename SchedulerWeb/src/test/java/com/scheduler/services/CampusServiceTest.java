package com.scheduler.services;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Campus;

public class CampusServiceTest extends BaseTest {

	@Autowired(required=true)
	CampusService campusService;
	
	@Test
	public void testSaveCampus(){
		Campus newCampus = new Campus();
		newCampus.setClientId(1);
		newCampus.setCampusName("Campus Test");
		newCampus.setCampusAddress("Campus Test Address");
		newCampus.setDateCreated(Date.valueOf("2013-12-01"));
		
		int newCampusId = campusService.saveCampus(newCampus);
		
		assertNotNull(newCampus);
		assertTrue("Failed to create campus", newCampusId>0);	
	}
	
	@Test
	public void testGetCampusById() {

		Campus newCampus = new Campus();
		newCampus.setClientId(1);
		newCampus.setCampusName("Campus Test");
		newCampus.setCampusAddress("Campus Test Address");
		newCampus.setDateCreated(Date.valueOf("2013-12-01"));
		int newCampusId = campusService.saveCampus(newCampus);
		
		Campus campusFromDB = campusService.getCampusById(1);
		String actualName = campusFromDB.getCampusName();
		
		String expectedName = "Campus Test";
		String actualAddress = campusFromDB.getCampusAddress();
		String expectedAddress = "Campus Test Address";

		assertEquals(actualName, expectedName);
		assertEquals(actualAddress, expectedAddress);
	}
	
	@Test
	public void testDeleteCampus() {

		Campus newCampus = new Campus();
		newCampus.setClientId(1);
		newCampus.setCampusName("Campus Test");
		newCampus.setCampusAddress("Campus Test Address");
		newCampus.setDateCreated(Date.valueOf("2013-12-01"));
		int newCampusId = campusService.saveCampus(newCampus);
		
		int campusId = 1;
		int actualResult = campusService.deleteCampus(1); 
		int expectedResult = 1;

		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testUpdateCampus() {

		Campus newCampus = new Campus();
		newCampus.setClientId(1);
		newCampus.setCampusName("Campus Test");
		newCampus.setCampusAddress("Campus Test Address");
		newCampus.setDateCreated(Date.valueOf("2013-12-01"));
		campusService.saveCampus(newCampus);
		int campusId = 1;
		
		Campus updateCampus = new Campus();
		updateCampus.setCampusId(campusId);
		updateCampus.setCampusName("Campus Test Update Name");
		updateCampus.setCampusAddress("Campus Test update Address");

		int actualUpdatedStatus = campusService.updateCampus(updateCampus);
		int expectedUpdatedStatus = 1;
		assertEquals(actualUpdatedStatus, expectedUpdatedStatus);

		Campus campusFromDB = campusService.getCampusById(1);
		String actualName = campusFromDB.getCampusName();
		String expectedName = "Campus Test Update Name";
		String actualAddress = campusFromDB.getCampusAddress();
		String expectedAddress = "Campus Test update Address";
		
		assertEquals(actualName, expectedName);
		assertEquals(actualAddress, expectedAddress);
	}
	
	@Test
	public void testFindAllCampuses() {
	  Campus newCampus = new Campus();
	  newCampus.setCampusId(5);
	  newCampus.setClientId(1);
	  newCampus.setCampusName("Campus New Test");
	  newCampus.setCampusAddress("Campus New Address");
	  newCampus.setDateCreated(Date.valueOf("2013-12-01"));
	 
	  campusService.saveCampus(newCampus);
	  
	  List<Campus> campuses = campusService.findAllCampuses(1);
	  assertNotNull(campuses);
	  assertTrue(campuses.size()>=0);
	}
}
