package com.schedulerapp.models;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class AppointmentDepartment extends Appointment  {
	public AppointmentDepartment(){
		
	}
	
	private String departmentName;
	
	public String getDepartmentName(){
		return departmentName;
	}
	public void setDepartmentName(String depName){
		departmentName = depName;
	}
	
	public static AppointmentDepartment getAppointmentFromJson(JSONObject obj) throws JSONException {
		AppointmentDepartment appointment = new AppointmentDepartment();
	      
		appointment.setMeetingNotes(obj.getString("meetingNotes"));
	      appointment.setMeetingFinished(obj.getString("meetingFinished"));
	      appointment.setOfficialId(obj.getInt("officialId"));
	      appointment.setAppointmentId(obj.getInt("appointmentId"));
	      String date = obj.getString("appointmentDate");
	      Date d = Date.valueOf(date);
	      appointment.setAppointmentDate(d);
	      appointment.setDepartmentTimeId(obj.getInt("departmentTimeId"));
	      appointment.setPurposeOfVisit(obj.getString("purposeOfVisit"));
	      appointment.setDepartmentName(obj.getString("departmentName"));
	      return appointment;
		
	}
}
