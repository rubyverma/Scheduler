package com.schedulerapp.jsonparser;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.models.User;

public class JsonParser {
	
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
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			campuses.add(Campus.getCampusFromJson(obj));
		}
	
	/*public static JSONObject tostr(String str)
	{
		JSONObject jObj = new JSONObject();
		String json = "";
		
		JSONObject jsonObject = new JSONObject();
		try {
			
			
			jsonObject.put("firstName",user.getFirstName());
			jsonObject.put("lastName",user.getLastName());
			
		return campuses;
			
		} catch (JSONException e) {
			e.printStackTrace();
	}

	public List<Department> parseDepartmentList(String result) throws NumberFormatException, JSONException {
		List<Department> departments = new ArrayList<Department>();
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
	
	public List<DepartmentTimeslotLinkage> parseDepartmenttimeslotLinkageList(String result) throws NumberFormatException, JSONException {
		List<DepartmentTimeslotLinkage> timeSlots = new ArrayList<DepartmentTimeslotLinkage>();
		JSONArray jObj = new JSONArray(result);
		for (int i=0; i<jObj.length(); i++) {
			JSONObject obj = jObj.getJSONObject(i);
			timeSlots.add(DepartmentTimeslotLinkage.getDepartmentTimeslotLinkageFromJson(obj));
		}
		return timeSlots;
	}	
}
