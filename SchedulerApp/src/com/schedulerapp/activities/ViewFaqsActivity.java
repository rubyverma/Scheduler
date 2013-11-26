package com.schedulerapp.activities;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.schedulerapp.adapters.CategoriesAdapter;
import com.schedulerapp.adapters.FaqAdapter;
import com.schedulerapp.models.Category;
import com.schedulerapp.models.Faq;
import com.schedulerapp.tasks.GetCategories;
import com.schedulerapp.tasks.GetFaqsByCategory;

public class ViewFaqsActivity extends ListActivity {
	
	private List<Category> categories;
	private List<Faq> faqs;
	private Category selectedCategory;
	private Spinner category_spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_faqs);
		
		category_spinner = (Spinner) findViewById(R.id.category_spinner);
		category_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				selectedCategory = (Category) parent.getItemAtPosition(pos);
				if(selectedCategory != null && selectedCategory.getCategoryId() != -1) {
					getFaqs();
				}				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});		
		
		getCategories();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_faqs, menu);
		return true;
	}

	public void getFaqs() {
		GetFaqsByCategory task = new GetFaqsByCategory();
		try {
			faqs = task.execute(Integer.toString(selectedCategory.getCategoryId())).get();
			getListView().setAdapter(new FaqAdapter(this, faqs));
			//category_spinner.setAdapter(new CategoriesAdapter(this, categories));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getCategories() {
		GetCategories task = new GetCategories();
		try {
			categories = task.execute().get();
			category_spinner.setAdapter(new CategoriesAdapter(this, categories));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
