package com.schedulerapp.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schedulerapp.activities.R;
import com.schedulerapp.models.Faq;

public class FaqAdapter  extends BaseAdapter {
	
	private final List<Faq> faqs;
	private LayoutInflater layoutInflater;
 
	public FaqAdapter(Context context, List<Faq> faqs) {
		this.faqs = faqs;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {
        return faqs.size();
    }
 
    @Override
    public Object getItem(int position) {
        return faqs.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = null;
		View rowView = layoutInflater.inflate(R.layout.list_faq, parent, false);
		
		textView = (TextView) rowView.findViewById(R.id.lbl_ques);
		textView.setText(faqs.get(position).getFaqQuestion());

		textView = (TextView) rowView.findViewById(R.id.lbl_ans);
		textView.setText(faqs.get(position).getFaqAnswer());
		
 		return rowView;
	}
}
