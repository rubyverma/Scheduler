package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departmenttimeslot {

	 private int departmentTimeId;
	 private int departmentId;
	 private int timeslotId;
	 private String weekdays;
	 private int capacity;
}
