package com.schedulerapp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {

	private int categoryId;
	private int officialId;
	private String categoryName;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getOfficialId() {
		return officialId;
	}
	public void setOfficialId(int officialId) {
		this.officialId = officialId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public static Category getSelectPropmpt() throws JSONException {
		Category cat = new Category();
		cat.setCategoryId(-1);
		cat.setCategoryName("Select Category");
		return cat;
	}	
			
	public static Category getCategoryFromJson(JSONObject obj) throws JSONException {
		Category cat = new Category();
		cat.setCategoryName(obj.getString("categoryName"));
		cat.setCategoryId(obj.getInt("categoryId"));
		cat.setOfficialId(obj.getInt("officialId"));		
		return cat;
	}	
}
