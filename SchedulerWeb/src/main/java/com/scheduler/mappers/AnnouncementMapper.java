package com.scheduler.mappers;

import java.util.List;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Announcement;

@Repository(value = "announcementMapper")
@Component
public interface AnnouncementMapper {

	List<Announcement> getAllAnnouncements(int userId) throws BadSqlGrammarException;
}
