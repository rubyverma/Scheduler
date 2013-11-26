package com.schedulerapp.tasks;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.schedulerapp.httprequests.HttpClient;

import com.schedulerapp.jsonparser.ResponseParser;
import com.schedulerapp.models.Category;
import com.schedulerapp.utils.UrlUtils;

public class GetCategories extends
		AsyncTask<String, Void, List<Category>> {

	@Override
	protected void onPostExecute(List<Category> result) {
		super.onPostExecute(result);
	}

	@Override
	protected List<Category> doInBackground(String... args) {
		List<Category> categories = new ArrayList<Category>();
		String result = HttpClient.SendHttpGET(UrlUtils.BASE_URL + UrlUtils.GET_CATEGORIES);
		ResponseParser parser = new ResponseParser();
		try {
			categories = parser.parseCategoryList(result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return categories;
	}

	}
