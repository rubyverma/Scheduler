package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;


import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Department;
import com.schedulerapp.utils.UrlUtils;

public class GetDepartementByCampus extends AsyncTask<String, Void, List<Department>> {
	@Override
    protected void onPostExecute(List<Department> result) {
      super.onPostExecute(result);
    }

    @Override
    protected List<Department> doInBackground(String... params) {
      List<Department> departments = new ArrayList<Department>();
      String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_DEPARTMENT + params[0]);
      ResponseParser parser = new ResponseParser();
      try {
    	  departments = parser.parseDepartmentList(result);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (JSONException e) {
        e.printStackTrace();
      }
      return departments;
    }
}
