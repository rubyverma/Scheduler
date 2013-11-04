package com.schedulerapp.models;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

public class Appointment {

    private int appointmentId;
    private int departmentTimeId;
    private int userId;
    private int officialId;
    private Date appointmentDate;
    private String purposeOfVisit;
    private Time startTime;
    private Time endTime;
    private String meetingFinished;
    private String meetingNotes;
    private Date dateCreated;
        
    public int getAppointmentId() {
      return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
      this.appointmentId = appointmentId;
    }
    public int getDepartmentTimeId() {
      return departmentTimeId;
    }
    public void setDepartmentTimeId(int departmentTimeId) {
      this.departmentTimeId = departmentTimeId;
    }
    public int getUserId() {
      return userId;
    }
    public void setUserId(int userId) {
      this.userId = userId;
    }
    public int getOfficialId() {
      return officialId;
    }
    public void setOfficialId(int officialId) {
      this.officialId = officialId;
    }
    public Date getAppointmentDate() {
      return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
      this.appointmentDate = appointmentDate;
    }
    public String getPurposeOfVisit() {
      return purposeOfVisit;
    }
    public void setPurposeOfVisit(String purposeOfVisit) {
      this.purposeOfVisit = purposeOfVisit;
    }
    public Time getStartTime() {
      return startTime;
    }
    public void setStartTime(Time startTime) {
      this.startTime = startTime;
    }
    public Time getEndTime() {
      return endTime;
    }
    public void setEndTime(Time endTime) {
      this.endTime = endTime;
    }
    public String getMeetingFinished() {
      return meetingFinished;
    }
    public void setMeetingFinished(String meetingFinished) {
      this.meetingFinished = meetingFinished;
    }
    public String getMeetingNotes() {
      return meetingNotes;
    }
    public void setMeetingNotes(String meetingNotes) {
      this.meetingNotes = meetingNotes;
    }
    public Date getDateCreated() {
      return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
      this.dateCreated = dateCreated;
    }
    
    public static Appointment getAppointmentFromJson(JSONObject obj) throws JSONException {
      Appointment appointment = new Appointment();
      appointment.setMeetingNotes(obj.getString("meetingNotes"));
      appointment.setMeetingFinished(obj.getString("meetingFinished"));
      appointment.setOfficialId(obj.getInt("officialId"));
      appointment.setAppointmentId(obj.getInt("appointmentId"));
      String date = obj.getString("appointmentDate");
      Date d = Date.valueOf(date);
      appointment.setAppointmentDate(d);
      appointment.setDepartmentTimeId(obj.getInt("departmentTimeId"));
      appointment.setPurposeOfVisit(obj.getString("purposeOfVisit"));
      return appointment;
    }   
}

