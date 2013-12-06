package com.schedulerapp.activities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Announcement;
import com.schedulerapp.utils.UrlUtils;

	public class GetAllAnnouncements extends AsyncTask<String, Void, List<Announcement>> {

		@Override
	    protected void onPostExecute(List<Announcement> result) {
	      super.onPostExecute(result);
	    }

	    @Override
	    protected List<Announcement> doInBackground(String... params) {
	      List<Announcement> announcement = new ArrayList<Announcement>();
	      String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_ANNOUNCEMENTS + params[0]);
	      ResponseParser parser = new ResponseParser();
	      try {
	    	  announcement = parser.parseAnnouncementList(result);
	      } catch (NumberFormatException e) {
	        e.printStackTrace();
	      } catch (JSONException e) {
	        e.printStackTrace();
	      }
	      return announcement;
	    }
	}
