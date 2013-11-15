package com.scheduler.models;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentTimeslotLinkage {
	
		private int departmentTimeId;
		private Time startTime;
		private Time stopTime;
		private Date appointmentDate;
		private String weekdays;
		private int capacity;
}
