package com.schedulerapp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class DepartmentTimeslotLinkage extends Departmenttimeslot{
	
		private String startTime;
		private String stopTime;
		
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getStopTime() {
			return stopTime;
		}
		public void setStopTime(String stopTime) {
			this.stopTime = stopTime;
		}
		
		public static DepartmentTimeslotLinkage getSelectPropmpt() throws JSONException {
			DepartmentTimeslotLinkage departmenttimeslot = new DepartmentTimeslotLinkage();
			departmenttimeslot.setDepartmentTimeId(-1);
			departmenttimeslot.setStartTime("Select Timeslot");
			departmenttimeslot.setStopTime("");
			return departmenttimeslot;
		}
		
		public static DepartmentTimeslotLinkage getDepartmentTimeslotLinkageFromJson(JSONObject obj) throws JSONException {
			DepartmentTimeslotLinkage departmenttimeslot = new DepartmentTimeslotLinkage();
			departmenttimeslot.setDepartmentTimeId(obj.getInt("departmentTimeId"));
			departmenttimeslot.setWeekdays(obj.getString("weekdays"));
			departmenttimeslot.setStartTime(obj.getString("startTime"));
			departmenttimeslot.setStopTime(obj.getString("stopTime"));
			
			System.out.println(obj.toString());
			return departmenttimeslot;	
		}		
}
