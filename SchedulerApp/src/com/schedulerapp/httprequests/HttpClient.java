package com.schedulerapp.httprequests;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
 
import android.util.Log;
 
public class HttpClient {
	private static final String TAG = "HttpClient";
 
	public static String SendHttpPost(String URL, JSONObject jsonObjSend) {
 
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPostRequest = new HttpPost(URL);
 
			StringEntity se;
			se = new StringEntity(jsonObjSend.toString());
 
			httpPostRequest.setEntity(se);
			httpPostRequest.setHeader("Accept", "application/json");
			httpPostRequest.setHeader("Content-type", "application/json");
 
			long t = System.currentTimeMillis();
			HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);
			Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");
 
			HttpEntity entity = response.getEntity();
 
			if (entity != null) {
				InputStream instream = entity.getContent();
				String resultString= convertStreamToString(instream);
				instream.close();
				return resultString;
			} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String SendHttpGET(String URL) {
		String resultString = "";
		try {
			
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGetRequest = new HttpGet(URL);
 
			httpGetRequest.setHeader("Accept", "application/json");
			httpGetRequest.setHeader("Content-type", "application/json");
 
			long t = System.currentTimeMillis();
			HttpResponse response = (HttpResponse) httpclient.execute(httpGetRequest);
			Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");
 
			HttpEntity entity = response.getEntity();
 
			if (entity != null) {
				InputStream instream = entity.getContent();
				resultString= convertStreamToString(instream);
				instream.close();
			} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultString;
	}
 
	private static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
 
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
 
}