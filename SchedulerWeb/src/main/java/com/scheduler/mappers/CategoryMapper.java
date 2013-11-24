package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Announcement;
import com.scheduler.models.Category;
import com.scheduler.models.UserAnnouncement;

@Repository(value="categoryMapper")
@Component
public interface CategoryMapper {

	int addCategory(Category category);

	int updateCategory(Category category);

	int deleteCategory(@Param("categoryId") int categoryId);
	
	List<Category> getAllCategories() throws BadSqlGrammarException;
	
	Category getCategory(@Param("categoryId") int categoryId);

}
