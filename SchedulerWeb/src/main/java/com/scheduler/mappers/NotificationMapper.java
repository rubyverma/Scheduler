package com.scheduler.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value="notificationMapper")
@Component
public interface NotificationMapper {
	
	boolean viewAllNotification(@Param("user_id") int user_id )  throws BadSqlGrammarException;
}
