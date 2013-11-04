package com.schedulerapp.models;

import org.json.JSONException;
import org.json.JSONObject;


public class User{
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static User getUserFromJson(JSONObject obj) throws JSONException {
		User user = new User();
		user.setId(obj.getInt("id"));
		user.setEmail(obj.getString("email"));
		user.setFirstname(obj.getString("firstname"));
		user.setLastname(obj.getString("lastname"));
		return user;
	}


}
