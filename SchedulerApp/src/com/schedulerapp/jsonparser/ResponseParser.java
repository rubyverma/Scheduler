package com.schedulerapp.jsonparser;
 
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import com.schedulerapp.models.Announcement;
import com.schedulerapp.models.AppointmentDepartment;
import com.schedulerapp.models.Campus;
import com.schedulerapp.models.Category;
import com.schedulerapp.models.Department;
import com.schedulerapp.models.DepartmentTimeslotLinkage;
import com.schedulerapp.models.Departmenttimeslot;
import com.schedulerapp.models.Faq;
import com.schedulerapp.models.Notification;
import com.schedulerapp.models.User;
 
public class ResponseParser {
	
	public User parseUser(String userJson) throws NumberFormatException, JSONException {		
		JSONObject jObj = new JSONObject(userJson);		
		return User.getUserFromJson(jObj);
	}

	public List<AppointmentDepartment> parseAppointments(String result) throws NumberFormatException, JSONException {		
		List<AppointmentDepartment> appointments = new ArrayList<AppointmentDepartment>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			appointments.add(AppointmentDepartment.getAppointmentFromJson(obj));
		}
		return appointments;
	}
	
	public List<Campus> parseCampusList(String result) throws NumberFormatException, JSONException {
		List<Campus> campuses = new ArrayList<Campus>();
		campuses.add(Campus.getSelectPropmpt());
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			campuses.add(Campus.getCampusFromJson(obj));
		}
		return campuses;
	}
 
	public List<Department> parseDepartmentList(String result) throws NumberFormatException, JSONException {
		List<Department> departments = new ArrayList<Department>();
		departments.add(Department.getSelectPropmpt());
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			departments.add(Department.getDepartmentFromJson(obj));
		}
		return departments;
	}
	
	public List<Departmenttimeslot> parseDepartmenttimeslotList(String result) throws NumberFormatException, JSONException {
		List<Departmenttimeslot> timeSlots = new ArrayList<Departmenttimeslot>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			timeSlots.add(Departmenttimeslot.getDepartmenttimeslotFromJson(obj));
		}
		return timeSlots;
	}
	
	public List<Category> parseCategoryList(String result) throws NumberFormatException, JSONException {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.getSelectPropmpt());
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			categories.add(Category.getCategoryFromJson(obj));
		}
		return categories;
	}

	
	public List<Faq> parseFaqsList(String result) throws NumberFormatException, JSONException {
		List<Faq> faqs = new ArrayList<Faq>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			faqs.add(Faq.getFaqFromJson(obj));
		}
		return faqs;
	}
	
	public List<DepartmentTimeslotLinkage> parseDepartmenttimeslotLinkageList(String result) throws NumberFormatException, JSONException {
		List<DepartmentTimeslotLinkage> timeSlots = new ArrayList<DepartmentTimeslotLinkage>();
		timeSlots.add(DepartmentTimeslotLinkage.getSelectPropmpt());
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			timeSlots.add(DepartmentTimeslotLinkage.getDepartmentTimeslotLinkageFromJson(obj));
		}
		return timeSlots;
	}
	
	public List<Notification> parseNotificationList(String result) throws NumberFormatException, JSONException {
		List<Notification> notification = new ArrayList<Notification>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			notification.add(Notification.getNotificationFromJson(obj));
		}
		return notification;
	}	
	
	public List<Announcement> parseAnnouncementList(String result) throws NumberFormatException, JSONException {
		List<Announcement> announcement = new ArrayList<Announcement>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			announcement.add(Announcement.getAnnouncementFromJson(obj));
		}
		return announcement;
	}	
}
