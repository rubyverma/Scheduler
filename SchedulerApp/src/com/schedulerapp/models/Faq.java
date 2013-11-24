package com.schedulerapp.models;

import org.json.JSONException;
import org.json.JSONObject;


public class Faq {
	
	private int faqId;
	private int categoryId;
	private int officialId;
	private String faqQuestion;
	private String faqAnswer;
	
	public int getFaqId() {
		return faqId;
	}
	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getOfficialId() {
		return officialId;
	}
	public void setOfficialId(int officialId) {
		this.officialId = officialId;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	
	public static Faq getFaqFromJson(JSONObject obj) throws JSONException {
		Faq faq = new Faq();
		faq.setFaqId(obj.getInt("faqId"));
		faq.setCategoryId(obj.getInt("categoryId"));
		faq.setOfficialId(obj.getInt("officialId"));
		faq.setFaqQuestion(obj.getString("faqQuestion"));
		faq.setFaqAnswer(obj.getString("faqAnswer"));		
		return faq;
	}	
}
