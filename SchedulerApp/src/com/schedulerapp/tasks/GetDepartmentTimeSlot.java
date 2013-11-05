package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;


import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.DepartmentTimeslotLinkage;
import com.schedulerapp.utils.UrlUtils;

public class GetDepartmentTimeSlot extends AsyncTask<String, Void, List<DepartmentTimeslotLinkage>> {
	@Override
    protected void onPostExecute(List<DepartmentTimeslotLinkage> result) {
      super.onPostExecute(result);
    }

    @Override
    protected List<DepartmentTimeslotLinkage> doInBackground(String... params) {
      List<DepartmentTimeslotLinkage> timeslots = new ArrayList<DepartmentTimeslotLinkage>();
      String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_TIME_SLOT + params[0]);
      ResponseParser parser = new ResponseParser();
      try {
    	  timeslots = parser.parseDepartmenttimeslotLinkageList(result);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (JSONException e) {
        e.printStackTrace();
      }
      return timeslots;
    }
}
