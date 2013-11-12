package com.scheduler.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.AppointmentMapper;
import com.scheduler.mappers.CampusMapper;
import com.scheduler.models.Campus;
import com.scheduler.models.User;

@Component
public class CampusService {

	@Autowired(required = true)
	private CampusMapper campusMapper;
	
	public List<Campus> campusByClient(@Param("clientId") int clientId )  throws BadSqlGrammarException {
		List<Campus> campuses = new ArrayList<Campus>();
		campuses = campusMapper.getCampusByClient(clientId);
		return campuses;
	}
	
	public List<Campus> findAllCampuses(int clientId)
			throws BadSqlGrammarException {
		return campusMapper.findAllCampuses(clientId);
	}
	
	public int deleteCampus(@Param("campusId") int campusId)  throws BadSqlGrammarException {
		return campusMapper.deleteCampus(campusId);
	}
	
	public int saveCampus(Campus campus) throws BadSqlGrammarException {
		return campusMapper.saveCampus(campus);
	}
	
	public Campus getCampusById(@Param("campusId") int campusId)  throws BadSqlGrammarException {
		return campusMapper.getCampusById(campusId);
	}
	
	public int updateCampus(Campus campus) throws BadSqlGrammarException{
		return campusMapper.updateCampus(campus);
	}
	
	public int validateEntry(Campus campus) throws BadSqlGrammarException{
		return campusMapper.validateEntry(campus);
	}
}
