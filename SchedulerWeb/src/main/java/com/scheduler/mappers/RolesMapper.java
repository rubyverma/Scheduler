package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Department;
import com.scheduler.models.Roles;

@Repository(value="rolesMapper")
@Component
public interface RolesMapper {
	
	List<Roles> getRoles();
	Roles getRolesByRoleId(@Param("roleId") int roleId);
	int saveRole(Roles role);
	int deleteRole(@Param("roleId") int roleId);
	int updateRole(Roles role);
}
