package com.schedulerapp.jsonparser;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.models.User;

public class jsonParser {
	public static String toJSon(User user)
	{
		String jsonData = "";
		JSONObject jsonObject = new JSONObject();
		JSONObject wrapper = new JSONObject();
		try {
			
			jsonObject.put("firstName",user.getFirstname());
			jsonObject.put("lastName",user.getLastname());
			
			//wrapper.put("user", jsonObject);
		//	jsonData = wrapper.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
	}
	
	/*public static JSONObject tostr(String str)
	{
		JSONObject jObj = new JSONObject();
		String json = "";
		
		JSONObject jsonObject = new JSONObject();
		try {
			
			
			jsonObject.put("firstName",user.getFirstName());
			jsonObject.put("lastName",user.getLastName());
			
			return jsonObject.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jObj;
		
	}*/
	


}
