package com.schedulerapp.models;

import org.json.JSONException;
import org.json.JSONObject;


public class Departmenttimeslot {

	 public int getDepartmentTimeId() {
		return departmentTimeId;
	}
	public void setDepartmentTimeId(int departmentTimeId) {
		this.departmentTimeId = departmentTimeId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getTimeslotId() {
		return timeslotId;
	}
	public void setTimeslotId(int timeslotId) {
		this.timeslotId = timeslotId;
	}
	public String getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	 private int departmentTimeId;
	 private int departmentId;
	 private int timeslotId;
	 private String weekdays;
	 private int capacity;
	 
	public static Departmenttimeslot getDepartmenttimeslotFromJson(JSONObject obj) throws JSONException {
		Departmenttimeslot departmenttimeslot = new Departmenttimeslot();
		departmenttimeslot.setCapacity(obj.getInt("capacity"));
		departmenttimeslot.setDepartmentId(obj.getInt("departmentId"));
		departmenttimeslot.setDepartmentTimeId(obj.getInt("departmentTimeId"));
		departmenttimeslot.setTimeslotId(obj.getInt("timeslotId"));
		departmenttimeslot.setWeekdays(obj.getString("weekdays"));
		return departmenttimeslot;
	}	 
}
