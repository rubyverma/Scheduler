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
import com.scheduler.models.UserAnnouncement;
import com.scheduler.request.SendPostRequest;

@Component
public class CategoryService {
	
	@Autowired(required = true)
	private CategoryMapper categoryMapper;

	public void addCategory(Category category) {
		categoryMapper.addCategory(category);
	}
	
	public int deleteCategory(@Param("categoryId") int categoryId){
		return (categoryMapper.deleteCategory(categoryId));
	}
	
	public int updateCategory(Category category){
		return (categoryMapper.updateCategory(category));
	}
	
	public List<Category> getAllCategory(){
		return (categoryMapper.getAllCategories());
	}
	
	public Category getCategory(int categoryId){
		Category category = categoryMapper.getCategory(categoryId);
		return category;
	}
}
