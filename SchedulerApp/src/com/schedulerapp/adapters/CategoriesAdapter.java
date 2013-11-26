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
import com.schedulerapp.models.Category;

public class CategoriesAdapter  extends BaseAdapter {
	
	private final List<Category> categories;
	private LayoutInflater layoutInflater;
 
	public CategoriesAdapter(Context context, List<Category> categories) {
		this.categories = categories;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {
        return categories.size();
    }
 
    @Override
    public Object getItem(int position) {
        return categories.get(position);
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
		textView.setText(categories.get(position).getCategoryName());
		
 		return rowView;
	}
}
