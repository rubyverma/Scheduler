package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Campus;
import com.schedulerapp.utils.UrlUtils;

public class GetCampusesByClient extends AsyncTask<String, Void, List<Campus>> {

	@Override
    protected void onPostExecute(List<Campus> result) {
      super.onPostExecute(result);
    }

    @Override
    protected List<Campus> doInBackground(String... args) {
      List<Campus> campuses = new ArrayList<Campus>();
      String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_CAMPUS + args[0]);
      ResponseParser parser = new ResponseParser();
      try {
    	  campuses = parser.parseCampusList(result);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (JSONException e) {
        e.printStackTrace();
      }
      return campuses;
    }

}
