package com.schedulerapp.models;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Campus {
	
	private int campusId;
	private int clientId;
	private String campusName;
	private String campusAddress;
	private Date dateCreated;
	
	public int getCampusId() {
		return campusId;
	}
	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getCampusAddress() {
		return campusAddress;
	}
	public void setCampusAddress(String campusAddress) {
		this.campusAddress = campusAddress;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public static Campus getSelectPropmpt() throws JSONException {
		Campus campus = new Campus();
		campus.setCampusId(-1);
		campus.setCampusName("Select Campus");
		return campus;
	}
	
			
	public static Campus getCampusFromJson(JSONObject obj) throws JSONException {
		Campus campus = new Campus();
		campus.setCampusId(obj.getInt("campusId"));
		campus.setClientId(obj.getInt("clientId"));
		campus.setCampusName(obj.getString("campusName"));
		campus.setCampusAddress(obj.getString("campusAddress"));
		return campus;
	}	
}
































