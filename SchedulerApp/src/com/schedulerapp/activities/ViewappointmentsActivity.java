package com.schedulerapp.activities;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.adapters.CampusAdapter;
import com.schedulerapp.tasks.GetAppointments;
import com.schedulerapp.tasks.GetCampusesByClient;
import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.httprequests.HttpRequests;
import com.schedulerapp.models.AppointmentDepartment;
import com.schedulerapp.models.User;
import com.schedulerapp.preferences.SessionStorage;

import android.R.color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Layout.Alignment;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewappointmentsActivity extends Activity {
	public List<AppointmentDepartment> appointments;
	public StringBuilder builder = new StringBuilder();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewappointments);
		SessionStorage storage = new SessionStorage(this);
		String userId = storage.GetPreferences("userId");
		GetAppointments task = new GetAppointments();
		try {
			appointments = task.execute(userId).get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (AppointmentDepartment app: appointments){
			builder.append(app.getAppointmentDate()).append(";").append(app.getDepartmentName()).append(";")
							.append(app.getPurposeOfVisit()).append(";").append(app.getMeetingNotes()).append(";")
							.append(app.getMeetingFinished()).append("_");
			
		}
		
		builder.toString();
		System.out.println(builder);
		String st = new String(builder);
	    Log.d("Main",st);
	    String[] rows  = st.split("_");
	    LinearLayout linearLayout = (LinearLayout)findViewById(R.id.appointmentview);
	    
	    
	    for(int i=0;i<rows.length;i++){
	        Log.d("Rows",rows[i]);
	        String row  = rows[i];
	        TableLayout tablelayout = new TableLayout(this);
	        tablelayout.setBackgroundColor(Color.LTGRAY);
	        TableLayout blankTablelayout = new TableLayout(this);
	        blankTablelayout.setBackgroundColor(Color.WHITE);
	        blankTablelayout.setPadding(0, 5, 0, 0);
	        final String[] cols = row.split(";");
	        
	        for (int j = 0; j < cols.length; j++) {             
	            final String col = cols[j];
	            TableRow tr = new TableRow(this);
	            tr.setPadding(1, 2, 1, 2);
	            String name="";
	            TextView label = new TextView(this);
	            TextView value = new TextView(this);
			    switch (j)
			    {
			    case 0:
			    	name = "Date:- ";
			    	break;
			    case 1:
			    	name = "Department:- ";
			    	break;
			    case 2:
			    	name = "Purpose of Visit:- ";
			    	break;
			    case 3:
			    	name = "Meeting Notes:- ";
			    	break;
			    case 4:
			    	name = "Meeting State:- ";
			    	break;
			    }
	            label.setText(name);
	            label.setTextColor(Color.rgb(0,25,90));
	            label.setGravity(Gravity.RIGHT);
	            label.setPadding(0, 0, 5, 0);
	            if (j ==4){
	            	if (col.equals("C")){
	            		value.setText("Canceled");
	            		value.setTextColor(Color.rgb(80,0,80));
	            	}
	            	else if (col.equals("Y")){
	            		value.setText("Completed");
	            		value.setTextColor(Color.DKGRAY);
	            	}
	            	else if (col.equals("L")){
	            		value.setText("Late");
	            		value.setTextColor(Color.RED);
	            	}
	            	else {
	            		value.setText("Not started");
	            		value.setTextColor(Color.rgb(10, 120,10));
	            	}
	            }
	            else {
	            	if (col.equals("null")){
		            	value.setText("");
		            	value.setTextColor(Color.BLACK);
	            	}
	            	else {
		            	value.setText(col);
		            	value.setTextColor(Color.BLACK);
	            	}

	            }
	            
	            tr.addView(label);
	            tr.addView(value);
	            tablelayout.addView(tr);
            }
	        linearLayout.addView(tablelayout);
	        linearLayout.addView(blankTablelayout);
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewappointments, menu);
		return true;
	}

}
