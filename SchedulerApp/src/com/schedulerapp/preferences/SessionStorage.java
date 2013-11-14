package com.schedulerapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionStorage {

	private Context context;

	public SessionStorage(Context context) {
		this.context = context;
	}

	public void SavePreferences(String key, String value) {

		SharedPreferences sessionInfo = this.context.getSharedPreferences(
				"session", Context.MODE_PRIVATE);

		Editor editor = sessionInfo.edit();
		editor.putString(key, value);
		editor.commit();

	}
	
	public String GetPreferences(String key) {

		SharedPreferences sessionInfo = this.context.getSharedPreferences(
				"session", Context.MODE_PRIVATE);

		return sessionInfo.getString(key, "0");

	}
	
	public void LogoutUser() {
		
		SharedPreferences sessionInfo = this.context.getSharedPreferences(
				"session", Context.MODE_PRIVATE);

		Editor editor = sessionInfo.edit();
		editor.putString("userId", "0");
		editor.putString("username", "");
		editor.commit();
		
	}

}
