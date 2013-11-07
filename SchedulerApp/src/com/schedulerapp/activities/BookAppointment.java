package com.schedulerapp.activities;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

import com.schedulerapp.R;
import com.schedulerapp.adapters.CampusAdapter;
import com.schedulerapp.adapters.DepartmentAdapter;
import com.schedulerapp.adapters.TimeSlotAdapter;
import com.schedulerapp.models.Campus;
import com.schedulerapp.models.Department;
import com.schedulerapp.models.DepartmentTimeslotLinkage;
import com.schedulerapp.tasks.GetCampusesByClient;
import com.schedulerapp.tasks.GetDepartementByCampus;
import com.schedulerapp.tasks.GetDepartmentTimeSlot;

public class BookAppointment extends Activity {
	
	TextView txtData;
	List<Campus> campuses;
	List<Department> departments;
	List<DepartmentTimeslotLinkage> timeslots;
	Spinner campusSpinner;
	Spinner deptSpinner;
	Spinner timeSlotSpinner;
	
	Campus selectedCampus;
	Department selectedDepartment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_appointment);
		campusSpinner = (Spinner) findViewById(R.id.campus_spinner);
		deptSpinner = (Spinner) findViewById(R.id.department_spinner);
		timeSlotSpinner = (Spinner) findViewById(R.id.timeslot_spinner);
		
		campusSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				selectedCampus = (Campus) parent.getItemAtPosition(pos);
				if(selectedCampus != null) {
					getDepartments();
				}				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		deptSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				selectedDepartment = (Department) parent.getItemAtPosition(pos);
				if(selectedDepartment != null) {
					getDepartmentTimeSlots();
				}				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		
		getCampuses();
	}
	
	public void getCampuses() {
		Long clientId = 1L;
		GetCampusesByClient task = new GetCampusesByClient();
		try {
			campuses = task.execute(clientId.toString()).get();
			campusSpinner.setAdapter(new CampusAdapter(this, campuses));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDepartments() {
		GetDepartementByCampus task = new GetDepartementByCampus();
		try {			
			departments = task.execute(Integer.toString(selectedCampus.getCampusId())).get();
			deptSpinner.setAdapter(new DepartmentAdapter(this, departments));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDepartmentTimeSlots() {
		GetDepartmentTimeSlot task = new GetDepartmentTimeSlot();
		try {
			String params = Integer.toString(selectedDepartment.getDepartmentId()) + "/" + "3-11-2013";
			timeslots = task.execute(params).get();
			timeSlotSpinner.setAdapter(new TimeSlotAdapter(this, timeslots));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAppointmentClick(View v) {
		try {
			final JSONObject jsonObjectUser = new JSONObject();
            jsonObjectUser.put("email", "adam@gmail.com");
            jsonObjectUser.put("firstname", "Adam");
            jsonObjectUser.put("lastname", "Smith");
            jsonObjectUser.put("id", 1);
	    } catch (JSONException e) {
	            e.printStackTrace();
	    }
	
	   // SendDataTask task = new SendDataTask();
	    // task.execute(jsonObjectUser);		
	}	
}
