package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.Category;
import com.scheduler.models.Faq;

public class ViewFaqsService extends BaseTest {

	 @Autowired(required = true)
		private ClientService clientService;
	 
	 @Test
	 public void testViewFaqs()
	 {
		 int categoryId = 1;
		 List<Category> categories = null;
         categories = clientService.findAllCategories();
         List<Faq> fQns = clientService.getFaqQns(categoryId);
         assertTrue("Failed to view faqs",fQns==null);
	 }
}
