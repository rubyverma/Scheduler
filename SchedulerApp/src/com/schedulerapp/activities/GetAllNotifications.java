package com.schedulerapp.activities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Notification;
import com.schedulerapp.utils.UrlUtils;

public class GetAllNotifications extends
		AsyncTask<String, Void, List<Notification>> {

	@Override
	protected void onPostExecute(List<Notification> result) {
		super.onPostExecute(result);
	}

	@Override
	protected List<Notification> doInBackground(String... params) {
		List<Notification> notification = new ArrayList<Notification>();
		String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL
				+ UrlUtils.GET_NOTIFICATIONS + params[0]);
		ResponseParser parser = new ResponseParser();
		try {
			notification = parser.parseNotificationList(result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return notification;
	}
}
