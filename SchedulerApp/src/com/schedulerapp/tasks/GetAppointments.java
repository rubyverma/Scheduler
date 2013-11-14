package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;

import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.AppointmentDepartment;
import com.schedulerapp.utils.UrlUtils;

public class GetAppointments extends
		AsyncTask<String, Void, List<AppointmentDepartment>> {

	@Override
	protected void onPostExecute(List<AppointmentDepartment> result) {
		super.onPostExecute(result);
	}

	@Override
	protected List<AppointmentDepartment> doInBackground(String... args) {
		int userId = Integer.parseInt(args[0]);
		List<AppointmentDepartment> appointments = new ArrayList<AppointmentDepartment>();
		String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL
				+ UrlUtils.GET_APPOINTMENTS + userId);
		ResponseParser parser = new ResponseParser();
		try {
			appointments = parser.parseAppointments(result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	}
