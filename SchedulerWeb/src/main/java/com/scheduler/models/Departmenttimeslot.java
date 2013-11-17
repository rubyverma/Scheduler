package com.scheduler.models;
import java.sql.Date;
import java.sql.Time;

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

	 private Time startTime;
	 private Time stopTime;	 
	 private String workingDays;
	 
	 public static String getWorkingDays(String weekdays) {
		String workingDays = "";
		char [] selectedDays = weekdays.toCharArray();
		int i = 0;
		for (char c : selectedDays) {
			if(c == '1') {
				workingDays = workingDays + getDay(i);
			}
			i++;
		}
		return workingDays.substring(0, workingDays.length() - 2);
	 }
	 
	 private static String getDay(int day) {
		 String strday = "";
		 if(day == 0) {
			 strday = "Monday, ";
		 } else if(day == 1) {
			 strday = "Tuesday, ";
		 } else if(day == 2) {
			 strday = "Wednesday, ";
		 } else if(day == 3) {
			 strday = "Thursday, ";
		 } else if(day == 4) {
			 strday = "Friday, ";
		 } else if(day == 5) {
			 strday = "Saturday, ";
		 } else if(day == 6) {
			 strday = "Sunday ";
		 }
		 return strday;
	 }
}

