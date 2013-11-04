package com.schedulerapp.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schedulerapp.activities.R;
import com.schedulerapp.models.Department;

public class DepartmentAdapter  extends BaseAdapter {
	
	private final List<Department> departments;
	private LayoutInflater layoutInflater;
 
	public DepartmentAdapter(Context context, List<Department> departments) {
		this.departments = departments;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {
        return departments.size();
    }
 
    @Override
    public Object getItem(int position) {
        return departments.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = null;
		View rowView = layoutInflater.inflate(R.layout.dept_spin, parent, false);
		
		textView = (TextView) rowView.findViewById(R.id.lbl_dept_spin);
		textView.setText(departments.get(position).getDepartmentName());
		
 		return rowView;
	}
}
