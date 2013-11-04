package com.schedulerapp.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewappointmentsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewappointments);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewappointments, menu);
		return true;
	}

}
