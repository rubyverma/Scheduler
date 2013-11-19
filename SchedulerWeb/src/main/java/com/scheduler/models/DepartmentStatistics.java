package com.scheduler.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentStatistics {
	private int departmentId;
	private String departmentName;
	private int totalAppointment;
	private int finishedAppointment;
	private int canceledAppointment;
	private int lateAppointment;
}

