package com.scheduler.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;

@Repository(value="generalUserMapper")
@Component
public interface GeneralUserMapper {

	String getUserRegistrationId(@Param("user_id") int user_id);
	int saveUser(GeneralUser generaluser) throws BadSqlGrammarException;
	int verifyUser(@Param("userId") int userId);
	String getUserToken(@Param("userId") int userId);
	int getLastUserId();

}
