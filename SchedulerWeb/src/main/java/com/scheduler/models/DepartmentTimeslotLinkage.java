package com.scheduler.models;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentTimeslotLinkage extends Departmenttimeslot{
	
		private Time startTime;
		private Time stopTime;
}
