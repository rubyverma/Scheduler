package com.scheduler.mappers;


import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.OfficialUser;

@Repository(value="officialUserMapper")
@Component
public interface OfficialUserMapper {

	OfficialUser authenticate(OfficialUser o);
    String getFirstName(@RequestParam("officialName")String officialName,@RequestParam("password")String password);
    int getOfficialId(@RequestParam("officialName")String officialName,@RequestParam("password")String password);
    List<OfficialUser> getOfficialUserByDepartment(@Param("departmentId") int departmentId);
	int saveOfficialUser(OfficialUser officialUser);
	int updateOfficialUser(OfficialUser officialUser);
	int deleteOfficialUser(@Param("officialId") int officialId);
	OfficialUser getOfficialUserById(@Param("officialId") int officialId);
	int resetPassword(@Param("email") String email,@Param("password") String password);
	int updatePassword(OfficialUser officialUser);
	int getStaffCount(@Param("department_id") int department_id);

}
