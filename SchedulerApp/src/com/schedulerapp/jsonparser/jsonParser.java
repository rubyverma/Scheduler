package com.schedulerapp.jsonparser;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.models.User;

public class jsonParser {
	
	public User parseUser(String userJson) throws NumberFormatException, JSONException {
		
		User user = new User();

		JSONObject jObj = new JSONObject(userJson);
		
		int user_id = jObj.getInt("id");
		String email = jObj.getString("email");
		String firstname = jObj.getString("firstname");
		String lastname = jObj.getString("lastname");
		
		
		user.setId(user_id);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		
		return user;
	}
	
	public static String toJSon(User user)
	{
		JSONObject jsonObject = new JSONObject();
		try {
			
			jsonObject.put("firstname",user.getFirstname());
			jsonObject.put("lastname",user.getLastname());
			
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
