package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.scheduler.models.OfficialUser;

@Repository(value="officialUserMapper")
@Component
public interface OfficialUserMapper {
	
	List<OfficialUser> getOfficialUserByDepartment(@Param("departmentId") int departmentId);
	int saveOfficialUser(OfficialUser officialUser);
	int updateOfficialUser(OfficialUser officialUser);
	int deleteOfficialUser(@Param("officialId") int officialId);
	OfficialUser getOfficialUserById(@Param("officialId") int officialId);
}
