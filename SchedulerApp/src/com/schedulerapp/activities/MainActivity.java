package com.schedulerapp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.scheduler.mobileapp.R;
import com.schedulerapp.httprequests.HttpRequests;
import com.schedulerapp.jsonparser.jsonParser;
import com.schedulerapp.models.User;

public class MainActivity extends Activity {

	private static final String TAG="com.scheduler.androidapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnGetData = (Button)findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				User user = new User();
		        
		        user.setFirstName("Sanket");
		        user.setLastName("Patel");
		        
		        SendDataTask task = new SendDataTask();
		        task.execute(user);	
			}
		});
    }

    private class SendDataTask extends AsyncTask<User, Void, String>{

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			((TextView) MainActivity.this.findViewById(R.id.txtData)).setText(result);
		}

		@Override
		protected String doInBackground(User... params) {
			HttpRequests client = new HttpRequests();
			String result = client.postJsonData(jsonParser.toJSon(params[0]));
			return result;
		}
    }

}
