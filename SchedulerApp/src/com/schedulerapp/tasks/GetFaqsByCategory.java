package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;

import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Faq;
import com.schedulerapp.utils.UrlUtils;

public class GetFaqsByCategory extends
		AsyncTask<String, Void, List<Faq>> {

	@Override
	protected void onPostExecute(List<Faq> result) {
		super.onPostExecute(result);
	}

	@Override
	protected List<Faq> doInBackground(String... args) {
		int categoryId = Integer.parseInt(args[0]);
		List<Faq> categories = new ArrayList<Faq>();
		String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_FAQS + categoryId);
		ResponseParser parser = new ResponseParser();
		try {
			categories = parser.parseFaqsList(result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return categories;
	}

	}
