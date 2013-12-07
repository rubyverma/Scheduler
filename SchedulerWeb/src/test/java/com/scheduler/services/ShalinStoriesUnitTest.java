/*
 * JUnit test class for services created by Shalin Banjara for all the stories worked on.
 * Testing for all the services
 * The database should be populated with all relevant dummy data before running or the sql file in the schema should contain the sql script for the same
 */
package com.scheduler.services;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Announcement;
import com.scheduler.models.Appointment;
import com.scheduler.models.Campus;
import com.scheduler.models.Category;
import com.scheduler.models.Department;
import com.scheduler.models.DepartmentTimeslotLinkage;
import com.scheduler.models.Roles;
import com.scheduler.models.Utility;

public class ShalinStoriesUnitTest extends BaseTest {

	@Autowired(required = true)
	AppointmentService appointmentService;
	
	@Autowired(required = true)
	DepartmentTimeslotService departmentTimeslotService;
	
	@Autowired(required = true)
	DepartmentService departmentService;
	
	@Autowired(required = true)
	CampusService campusService;
	
	@Autowired(required = true)
	RolesService roleService;
	
	@Autowired(required = true)
	CategoryService categoryService;
	
	@Autowired(required = true)
	ExpectedMeetingTimeService expectedMeetingTimeService;

	@Test
	public void testSaveAppointment() {
		//Validated departmenttimeID validation is performed in UI. User ID is taken from session.
		Appointment appointment = new Appointment();
		appointment.setDepartmentTimeId(1);
		appointment.setUserId(1);
		appointment.setPurposeOfVisit("Testing Save appointment Unit Test");
		appointment.setMeetingFinished("N");
		appointment.setAppointmentDate(Date.valueOf("2013-12-28"));
		
		int testId = appointmentService.saveAppointment(appointment);
		assertNotNull(appointment);
		assertTrue("Failed to create timeslot", testId > 0);
	}
	
	@Test
	public void testSaveRole() {
		//Validated departmenttimeID validation is performed in UI. User ID is taken from session.
		Roles role = new Roles();
		role.setClientId(1);
		role.setRoleName("Test Role");
		role.setDescription("Test Role Description");
		role.setPrivilege("Admin");
		int testId = roleService.saveRole(role);
		assertNotNull(role);
		assertTrue("Failed to create a Role", testId > 0);
	}
	
	@Test
	public void testTimeslotByDepartment() {
		// Test will pass if the that department has an available time-slot in the system.
		//Test will pass if the capacity for the that timeslot is not full and timeslot is available for that date(day) with the department.

		Utility utility = new Utility();
		utility.setAppointmentDate("2013-12-23");
		utility.setDepartmentId(1);
		List<DepartmentTimeslotLinkage> availableTimeslots = departmentTimeslotService.timeslotByDepartment(utility);
		assertTrue("No available timeslot " + availableTimeslots, availableTimeslots.size()>0);
	}
	
	@Test
	public void testDepartmentByCampus() {
		// Test will pass if department are available for the selected campus
		// Validations performed in UI
		int campusId = 1;
		List<Department> departments = departmentService.departmentByCampus(campusId);
		assertTrue("No departments available for campus Id specified " + campusId, departments.size()>0);
	}
	
	@Test
	public void testCampusByClient() {
		// Test will pass if department are available for the selected campus
		// Validations performed in UI
		int clientId = 1;
		List<Campus> campuses = campusService.campusByClient(clientId);
		assertTrue("No campuses available for campus Id specified " + clientId, campuses.size()>0);
	}
	
	@Test
	public void testGetRoles() {
		// Test will pass if database contains roles.
		// Validations performed in UI
		List<Roles> roles = roleService.getRoles();
		assertTrue("No roles defined for the system" + roles.size(), roles.size()>0);
	}
	
	@Test
	public void testGetRoleByRoleId() {
		// Test will pass if specified Role with specified role Id exist in the database.
		// Validations performed in UI
		int testRoleId = 2;
		Roles role = roleService.getRoleByRoleId(testRoleId);
		assertEquals(testRoleId, role.getRoleId());
	}
	
	@Test
	public void testGetAllCategory() {
		// Test will pass if any faq categories exist in the database.
		// Validations performed in UI
		List<Category> categories = categoryService.getAllCategory();
		assertTrue("No categories defined" + categories, categories.size()>0);
	}
	
	@Test
	public void testaddCategory() {
		// Test will pass if any faq categories exist in the database.
		// Validations performed in UI
		Category category = new Category();
		category.setCategoryName("Test Category");
		category.setOfficialId(1);
		categoryService.addCategory(category);
		assertNotNull(category);
		assertTrue("Failed to create timeslot", category.getCategoryName().equals("Test Category"));
	}
	
	@Test
	public void testGetExpectedMeetingTime() {
		// Test will pass if expected meeting time is calculated provided that the appointment id passed exist in the database.
		// Validations performed in UI
		String expectedMeetingTime = expectedMeetingTimeService.getExpectedMeetingTime(10);
		assertTrue("Failed to calculate Meeting timet", expectedMeetingTime.isEmpty());
	}
	
}
