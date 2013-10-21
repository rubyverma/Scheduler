package com.scheduler.models;

import java.sql.Date;

import lombok.Data;

@Data

public class Faq {
	
	private int m_faqId;
	private int m_categoryId;
	private int m_officialId;
	private String m_faqQuestion;
	private String m_faqAnswer;
	private Date m_createDate;
	
	public Faq()
	{
		
	}
	
	public Faq(int _faqId, int _categoryId, int _officialId, String _faqQuestion, String _faqAnswer, Date _createDate )
	{
		m_faqId = _faqId;
		m_categoryId = _categoryId;
		m_officialId = _officialId;
		m_faqQuestion = _faqQuestion;
		m_faqAnswer = _faqAnswer;
		m_createDate = _createDate;
	}
	
}
