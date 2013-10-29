package com.scheduler.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value="generalUserMapper")
@Component
public interface GeneralUserMapper {

	String getUserRegistrationId(@Param("user_id") int user_id);
	
	

}
