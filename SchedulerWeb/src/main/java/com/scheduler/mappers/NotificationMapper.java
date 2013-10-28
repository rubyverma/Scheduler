package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Notification;

@Repository(value="notificationMapper")
@Component
public interface NotificationMapper {
	
	boolean viewAllNotification(@Param("user_id") int user_id )  throws BadSqlGrammarException;

	int addNewNotification(Notification notification);

	List<Notification> findAllNotifications(@Param("userId") int userId);
}
