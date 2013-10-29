package com.scheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AnnouncementMapper;
import com.scheduler.models.Announcement;

@Component
public class AnnouncementService {

	@Autowired(required=true)
	private AnnouncementMapper announcementMapper;
	
	public List<Announcement> getAllAnnouncements(int userId) throws BadSqlGrammarException{
		return announcementMapper.getAllAnnouncements(userId);
		
	}
}
