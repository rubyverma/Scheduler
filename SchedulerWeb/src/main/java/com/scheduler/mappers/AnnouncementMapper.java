package com.scheduler.mappers;

import java.util.List;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Announcement;

import com.scheduler.models.UserAnnouncement;

@Repository(value="announcementMapper")
@Component
public interface AnnouncementMapper {

	int addNewAnnouncement(Announcement announcement);

	int addUserAnnouncement(List<UserAnnouncement> userAnnouncements);

	List<Announcement> getAllAnnouncements(int userId) throws BadSqlGrammarException;

}
