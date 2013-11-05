package com.schedulerapp.tasks;
 
import org.json.JSONException;
import org.json.JSONObject;
 
import android.os.AsyncTask;
 
import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.utils.UrlUtils;
 
public class SaveAppointment extends AsyncTask<JSONObject, Void, String> {
	@Override
    protected void onPostExecute(String result) {
      super.onPostExecute(result);
    }
 
    @Override
    protected String doInBackground(JSONObject... params) {
      String result = HttpClient.SendHttpPost(UrlUtils.BASE_URL + UrlUtils.SAVE_APPOINTMENT , params[0]);      
      try {
    	JSONObject jObj = new JSONObject(result);
		result = jObj.getString("result");
	} catch (JSONException e) {
		e.printStackTrace();
	}
      return result;
    }
}