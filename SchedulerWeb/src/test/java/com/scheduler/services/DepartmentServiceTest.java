package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
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

	
}
