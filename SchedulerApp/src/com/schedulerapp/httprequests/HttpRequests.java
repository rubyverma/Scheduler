package com.schedulerapp.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.net.http.AndroidHttpClient;
import android.util.Log;

public class HttpRequests {

	private static String URL="http://192.168.0.144:8080/Scheduler/official/meeting/testmeeting";
	InputStream is = null;
	JSONObject jObj = null;
	String json = "";

	public String postJsonData(String data)
	{
		try
		{
			StringBuffer buffer= new StringBuffer();
			//org.apache.http.client.HttpClient client= new DefaultHttpClient();
			org.apache.http.client.HttpClient client= AndroidHttpClient.newInstance("Android");
			HttpPost post = new HttpPost(URL);
			post.setHeader("Accept", "application/json");
			post.setHeader("Content-type", "application/json");
			List<NameValuePair> nvList= new ArrayList<NameValuePair>();
			BasicNameValuePair bnvp = new BasicNameValuePair("json", data);
			nvList.add(bnvp);
			post.setEntity(new UrlEncodedFormEntity(nvList));
			HttpResponse resp = client.execute(post);
			is = resp.getEntity().getContent();
			BufferedReader reader= new BufferedReader( new InputStreamReader(is));
			StringBuilder str= new StringBuilder();
			String line =null;
			while((line= reader.readLine())!=null)
			{
				str.append(line + "\n");
			}
			is.close();
			buffer.append(str.toString());
			return buffer.toString();
			
		}
		catch(Exception ex)
		{
			Log.e("HTTP", "Http Client Responding Error....");
		}
		return null;
	}
	
	
	
	public JSONObject getJSONFromUrl(String url) {

		org.apache.http.client.HttpClient client= AndroidHttpClient.newInstance("Android");
	    // Perform a GET request for a JSON list
	    HttpUriRequest request = new HttpGet(url);
	    // Get the response that sends back
	    HttpResponse response = null;
	    try {
	        response = client.execute(request);
	    } catch (ClientProtocolException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }

	    HttpEntity entity = response.getEntity();

	    try {
	        json = EntityUtils.toString(entity);
	    } catch (ParseException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }


	    try {
	        jObj = new JSONObject(json);
	    } catch (JSONException e) {
	        Log.e("JSON Parser", "Error parsing data " + e.toString());
	    }

	    // return JSON String
	    return jObj;

	}
}
