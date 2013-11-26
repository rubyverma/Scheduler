package com.scheduler.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AnnouncementMapper;
import com.scheduler.mappers.CategoryMapper;
import com.scheduler.mappers.FaqMapper;
import com.scheduler.mappers.GeneralUserMapper;
import com.scheduler.models.Announcement;
import com.scheduler.models.AppointmentList;
import com.scheduler.models.Category;
import com.scheduler.models.Faq;
import com.scheduler.models.UserAnnouncement;
import com.scheduler.request.SendPostRequest;

@Component
public class FaqService {
	
	@Autowired(required = true)
	private FaqMapper faqMapper;

	public void addFaq(Faq faq) {
		faqMapper.addFaq(faq);
	}
	
	public int deleteFaq(@Param("faqId") int faqId){
		return (faqMapper.deleteFaq(faqId));
	}
	
	public int updateFaq(Faq faq){
		return (faqMapper.updateFaq(faq));
	}
	
	public List<Faq> getAllFaqByCategory(@Param("categoryId") int categoryId){
		return (faqMapper.getAllFaqbyCategory(categoryId));
	}
	
	public Faq getFaq(int faqId) {
		Faq faq = faqMapper.getFaq(faqId);
		return faq;
	}
}
