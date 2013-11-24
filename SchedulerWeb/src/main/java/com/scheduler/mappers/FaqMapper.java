package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Announcement;
import com.scheduler.models.Category;
import com.scheduler.models.Faq;
import com.scheduler.models.UserAnnouncement;

@Repository(value="faqMapper")
@Component
public interface FaqMapper {

	int addFaq(Faq faq);

	int updateFaq(Faq faq);

	int deleteFaq(@Param("faqId") int faqId);
	
	List<Faq> getAllFaqbyCategory(@Param("categoryId") int categoryId) throws BadSqlGrammarException;
	
	Faq getFaq(@Param("faqId") int faqId);

}
