package com.schedulerapp.activities;

import com.schedulerapp.R;
import com.schedulerapp.gcm.GcmHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GcmHandler gcmHandler = new GcmHandler();
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
}