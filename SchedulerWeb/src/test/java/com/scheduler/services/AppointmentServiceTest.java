package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.AppointmentDepartment;

public class AppointmentServiceTest extends BaseTest {

	@Autowired(required=true)
	private AppointmentService appointmentService;

	
}
