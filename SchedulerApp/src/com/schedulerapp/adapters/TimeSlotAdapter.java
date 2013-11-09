package com.schedulerapp.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schedulerapp.activities.R;
import com.schedulerapp.models.DepartmentTimeslotLinkage;

public class TimeSlotAdapter  extends BaseAdapter {
	
	private final List<DepartmentTimeslotLinkage> timeslots;
	private LayoutInflater layoutInflater;
 
	public TimeSlotAdapter(Context context, List<DepartmentTimeslotLinkage> timeslots) {
		this.timeslots = timeslots;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {
        return timeslots.size();
    }
 
    @Override
    public Object getItem(int position) {
        return timeslots.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = null;
		View rowView = layoutInflater.inflate(R.layout.timeslot_spin, parent, false);
		
		textView = (TextView) rowView.findViewById(R.id.lbl_timeslot_spin);
		textView.setText(timeslots.get(position).getStartTime() + " - " + timeslots.get(position).getStopTime());
		
 		return rowView;
	}
}
