package com.scheduler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentStatistics;

public class DepartmentServiceTest extends BaseTest {

	@Autowired(required=true)
	private DepartmentService departmentService;
	
	
	@Test
	public void testDepartmentStats()
	{
		int departmentID=1;
		List<DepartmentStatistics> departmentStats= departmentService.getStatistics(departmentID);
		assertTrue("Failed to View Department Statistics",departmentStats.isEmpty()==false);
	}

	@Test
	public void testSaveDepartment(){
		Department newDepartment = new Department();
		newDepartment.setCampusId(1);
		newDepartment.setDepartmentName("Department Name Test");
		newDepartment.setDepartmentHod("Department HOD Test");
		newDepartment.setContactInfo(3653653644L);
		newDepartment.setDepartmentDescription("Department Description Test");
		newDepartment.setDateCreated(Date.valueOf("2013-12-01"));
		
		int newDepartmentId = departmentService.saveDepartment(newDepartment);
		
		assertNotNull(newDepartment);
		assertTrue("Failed to create department", newDepartmentId>0);
		}
	
	@Test
	public void testGetDepartmentById() {

		Department newDepartment = new Department();
		newDepartment.setCampusId(1);
		newDepartment.setDepartmentName("Department Name Test");
		newDepartment.setDepartmentHod("Department HOD Test");
		newDepartment.setContactInfo(3653653644L);
		newDepartment.setDepartmentDescription("Department Description Test");
		newDepartment.setDateCreated(Date.valueOf("2013-12-01"));
		
		int newDepartmentId = departmentService.saveDepartment(newDepartment);
		
		Department departmentFromDB = departmentService.getDepartmentById(1);
		String actualName = departmentFromDB.getDepartmentName();
		String expectedName = "Department Name Test";
		String actualHOD = departmentFromDB.getDepartmentHod();
		String expectedHOD = "Department HOD Test";
		Long actualContactInfo = departmentFromDB.getContactInfo();
		Long expectedContactInfo = 3653653644L;
		String actualDescription = departmentFromDB.getDepartmentDescription();
		String expectedDescription = "Department Description Test";
		
		assertEquals(actualName, expectedName);
		assertEquals(actualHOD, expectedHOD);
		assertEquals(actualContactInfo, expectedContactInfo);
		assertEquals(actualDescription, expectedDescription);
	}
	
	@Test
	public void testDeleteDepartment() {

		Department newDepartment = new Department();
		newDepartment.setCampusId(1);
		newDepartment.setDepartmentName("Department Name Test");
		newDepartment.setDepartmentHod("Department HOD Test");
		newDepartment.setContactInfo(3653653644L);
		newDepartment.setDepartmentDescription("Department Description Test");
		newDepartment.setDateCreated(Date.valueOf("2013-12-01"));
		
		int newDepartmentId = departmentService.saveDepartment(newDepartment);
		
		int departmentId = 1;
		int actualResult = departmentService.deleteDepartment(1); 
		int expectedResult = 1;

		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testUpdateDepartment() {

		Department newDepartment = new Department();
		newDepartment.setCampusId(1);
		newDepartment.setDepartmentName("Department Name Test");
		newDepartment.setDepartmentHod("Department HOD Test");
		newDepartment.setContactInfo(3653653644L);
		newDepartment.setDepartmentDescription("Department Description Test");
		newDepartment.setDateCreated(Date.valueOf("2013-12-01"));
		departmentService.saveDepartment(newDepartment);
		int departmentId = 1;
		
		Department updateDepartment = new Department();
		updateDepartment.setDepartmentId(departmentId);
		updateDepartment.setDepartmentName("Department Test Update Name");
		updateDepartment.setDepartmentHod("Department Test update HOD");
		updateDepartment.setContactInfo(4165244456L);
		updateDepartment.setDepartmentDescription("Department description updated test");
		updateDepartment.setDateCreated(Date.valueOf("2013-12-01"));

		int actualUpdatedStatus = departmentService.updateDepartment(updateDepartment);
		int expectedUpdatedStatus = 1;
		assertEquals(actualUpdatedStatus, expectedUpdatedStatus);

		Department departmentFromDB = departmentService.getDepartmentById(1);
		String actualName = departmentFromDB.getDepartmentName();
		String expectedName = "Department Test Update Name";
		String actualHOD = departmentFromDB.getDepartmentHod();
		String expectedHOD = "Department Test update HOD";
		Long actualInfo = departmentFromDB.getContactInfo();
		Long expectedInfo = 4165244456L;
		String actualDescription = departmentFromDB.getDepartmentDescription();
		String expectedDescription = "Department description updated test";
		Date actualDate = departmentFromDB.getDateCreated();
		Date expectedDate = Date.valueOf("2013-12-01");
		
		assertEquals(actualName, expectedName);
		assertEquals(actualHOD, expectedHOD);
		assertEquals(actualInfo, expectedInfo);
		assertEquals(actualDescription, expectedDescription);
		assertEquals(actualDate, expectedDate);
	}
}
