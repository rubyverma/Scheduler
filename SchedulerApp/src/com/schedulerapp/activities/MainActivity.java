package com.schedulerapp.activities;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.httprequests.HttpRequests;
import com.schedulerapp.preferences.SessionStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView txtData, tvWelcome;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		tvWelcome = (TextView) findViewById(R.id.tvWelcome);
		
		checkLoggedIn();

		// txtData = (TextView) findViewById(R.id.txtData);
		// Button btnCancel = (Button) findViewById(R.id.btnCancel);
		// final JSONObject jsonObjectUser = new JSONObject();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void addAppointmentClick(View v) {
		intent = new Intent(this, BookAppointment.class);
		startActivity(intent);
	}

	public void viewAppointmentClick(View v) {
		intent = new Intent(this, ViewappointmentsActivity.class);
		startActivity(intent);
	}

	public void viewAnnouncementsClick(View v) {
		intent = new Intent(this, ViewAnnouncement.class);
		startActivity(intent);
	}
	
	public void viewNotificationsClick(View v) {
		intent = new Intent(this, ViewNotifications.class);
		startActivity(intent);
	}
	
	public void viewFaqs(View v) {
		intent = new Intent(this, ViewFaqsActivity.class);
		startActivity(intent);
	}
	
	public void openSettings(View view) {
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}

	public void cancelAppointment(View v) {
		CancelAppointment task = new CancelAppointment();
		task.execute("http://10.0.2.2:8080/Scheduler/api/cancelappointment/1");
	}

	private class CancelAppointment extends AsyncTask<String, Void, String> {

		protected void onPostExecute(String message) {
			// TODO Auto-generated method stub
			super.onPostExecute(message);
			txtData.setText(message);
		}

		protected String doInBackground(String... params) {

			HttpRequests request = new HttpRequests();
			JSONObject result = request.getJSONFromUrl(params[0]);
			String message = "Failed";
			try {
				message = result.getString("responseMessage");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return message;
		}
	}

	public void LogoutUser(View view) {

		SessionStorage storage = new SessionStorage(this);
		storage.LogoutUser();

		Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);

	}

	public void checkLoggedIn() {

		// if already logged in, skip login activity
		SessionStorage storage = new SessionStorage(this);
		if (Integer.parseInt(storage.GetPreferences("userId")) == 0) {
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}
		
		String fullname = storage.GetPreferences("fullname");
		tvWelcome.setText("Welcome, " + fullname);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		checkLoggedIn();
	}

}