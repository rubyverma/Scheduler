package com.schedulerapp.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schedulerapp.activities.R;
import com.schedulerapp.models.Campus;

public class CampusAdapter  extends BaseAdapter {
	
	private final List<Campus> campuses;
	private LayoutInflater layoutInflater;
 
	public CampusAdapter(Context context, List<Campus> campuses) {
		this.campuses = campuses;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {
        return campuses.size();
    }
 
    @Override
    public Object getItem(int position) {
        return campuses.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = null;
		View rowView = layoutInflater.inflate(R.layout.campus_spin, parent, false);
		
		textView = (TextView) rowView.findViewById(R.id.lbl_campus_spin);
		textView.setText(campuses.get(position).getCampusName());
		
 		return rowView;
	}
}
