package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Campus;
@Repository(value="campusMapper")
@Component
public interface CampusMapper {
	
	List<Campus> getCampusByClient(@Param("clientId") int _clientId);
	
List<Campus> findAllCampuses(int clientId) throws BadSqlGrammarException;
	
	int deleteCampus(int campusId)  throws BadSqlGrammarException;
	
	int saveCampus(Campus campus);

	int updateCampus(Campus campus);
	
	Campus getCampusById(int campusId);
	
}
