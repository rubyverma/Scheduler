package com.schedulerapp.activities;

import com.schedulerapp.gcm.GcmHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class SettingsActivity extends Activity {

	EditText etGcmId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		etGcmId = (EditText) findViewById(R.id.etGCMId);
		GcmHandler handler = new GcmHandler(this);
		etGcmId.setText(handler.getRegistrationId(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
