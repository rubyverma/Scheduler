package com.schedulerapp.activities;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.schedulerapp.models.Announcement;
import com.schedulerapp.preferences.SessionStorage;

public class ViewAnnouncement extends Activity {

	ListView mainlist;
	List<Announcement> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_announcement);

		SessionStorage storage = new SessionStorage(this);
		String userId = storage.GetPreferences("userId");
		try {
			GetAllAnnouncements task = new GetAllAnnouncements();
			list = task.execute(userId).get();
			
			mainlist = (ListView) findViewById(R.id.mainlist);
			mainlist.setAdapter(new announcementListAdapter(this));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	class announcementListAdapter extends BaseAdapter {

		Context context;
		
		
		//Notification notification= new Notification();
		announcementListAdapter(Context c) throws InterruptedException, ExecutionException, NumberFormatException, JSONException {
			
			context = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.viewannouncement, arg2, false);
			TextView nDate = (TextView) row.findViewById(R.id.nDate);
			TextView nTitle = (TextView) row.findViewById(R.id.nTitle);
			TextView nDesc = (TextView) row.findViewById(R.id.nDesc);

			Announcement slr = list.get(arg0);
			nDate.setText(slr.getAnnouncementDate().toString());
			nTitle.setText(slr.getAnnouncementHeader());
			nDesc.setText(slr.getAnnouncementDescription());
			return row;
		}

	}
}
