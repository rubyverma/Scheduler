package com.schedulerapp.activities;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.scheduler.mobileapp.R;
import com.schedulerapp.gcm.GcmHandler;
import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.jsonParser;
import com.schedulerapp.models.User;

public class MainActivity extends Activity {

	//private static final String TAG = "com.scheduler.androidapp";
	private static String URL = "http://10.0.2.2:8080/Scheduler/user/api/save";
	
	TextView txtData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtData = (TextView) findViewById(R.id.txtData);
		
		GcmHandler gcmHandler = new GcmHandler(getApplicationContext());
		txtData.setText(gcmHandler.getRegistrationId(getApplicationContext()));
		
		final JSONObject jsonObjectUser = new JSONObject();
		Button btnGetData = (Button) findViewById(R.id.btnGetData);
		btnGetData.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
				try {
					
					jsonObjectUser.put("email", "adam@gmail.com");
					jsonObjectUser.put("firstname", "Adam");
					jsonObjectUser.put("lastname", "Smith");
					jsonObjectUser.put("id", 1);


				} catch (JSONException e) {
					e.printStackTrace();
				}

				SendDataTask task = new SendDataTask();
				task.execute(jsonObjectUser);
			}
		});
	}

	private class SendDataTask extends AsyncTask<JSONObject, Void, User> {

		@Override
		protected void onPostExecute(User result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			txtData.setText("Saved: " + result.getFirstname() + " to database");
		}

		@Override
		protected User doInBackground(JSONObject... params) {
			User u = null;
			String result = HttpClient.SendHttpPost(URL, params[0]);
			jsonParser parser = new jsonParser();
			try {
				u = parser.parseUser(result);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u;
		}
	}

}
