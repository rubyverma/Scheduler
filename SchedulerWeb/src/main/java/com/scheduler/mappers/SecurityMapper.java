package com.scheduler.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;
import com.scheduler.models.OfficialUser;

@Repository(value="securityMapper")
@Component
public interface SecurityMapper {
	
	GeneralUser getUserByEmail(@Param("email") String email);
	
	OfficialUser getOfficialByEmail(@Param("email") String email);
	
	Client getClientByEmail(@Param("email") String email);

}