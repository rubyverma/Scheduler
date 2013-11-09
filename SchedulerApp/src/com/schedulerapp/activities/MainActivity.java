package com.schedulerapp.activities;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.R;
import com.schedulerapp.gcm.GcmHandler;
import com.schedulerapp.httprequests.HttpRequests;
import com.schedulerapp.models.User;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG1 = "com.scheduler.androidapp";
	private static String URL = "http://10.0.2.2:8080/Scheduler/user/api/save";
	private static final String TAG = "GCM";
	TextView txtData;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//txtData = (TextView) findViewById(R.id.txtData);
		//Button btnCancel = (Button) findViewById(R.id.btnCancel);
		final JSONObject jsonObjectUser = new JSONObject();
		
		// Author- Sonny
		// To initialize Google Cloud messaging service
		GcmHandler gcmHandler = new GcmHandler(this);
		Log.i(TAG, "GCM registered: " + gcmHandler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void addAppointmentClick(View v) {
		intent = new Intent(this,BookAppointment.class);
		startActivity(intent);		
	}
	public void viewAppointmentClick(View v) {
		intent = new Intent(this,ViewappointmentsActivity.class);
		startActivity(intent);		
	}
	
	
	public void cancelAppointment(View v)
	{
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
			User u = null;
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
		
}