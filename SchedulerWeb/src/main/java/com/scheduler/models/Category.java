package com.scheduler.models;
import lombok.Data;


@Data
public class Category {
	
	private int m_categoryId;
	private int m_officialId;
	private String m_categoryName;
	
	public Category()
	{
		
	}
	
	public Category(int _categoryId, int _officialId, String _categoryName)
	{
		this.m_categoryId = _categoryId;
		this.m_officialId = _officialId;
		this.m_categoryName = _categoryName;
		
	}

}
