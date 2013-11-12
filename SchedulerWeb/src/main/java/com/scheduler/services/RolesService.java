package com.scheduler.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.DepartmentMapper;
import com.scheduler.mappers.RolesMapper;
import com.scheduler.models.Department;
import com.scheduler.models.Roles;

@Component
public class RolesService {
	
	@Autowired(required = true)
	private RolesMapper rolesMapper;
	
	public List<Roles> getRoles()  throws BadSqlGrammarException {
		List<Roles> roles = rolesMapper.getRoles();
		return roles;
	}
	
	public int saveRole(Roles role){
		return rolesMapper.saveRole(role);
	}
	
	public Roles getRoleByRoleId(@Param("roleId") int roleId){
		return rolesMapper.getRolesByRoleId(roleId);
	}
	
	public int updateRole(Roles role){
		return rolesMapper.updateRole(role);
	}
	
	public int deleteRole(@Param("roleId") int roleId){
		return rolesMapper.deleteRole(roleId);
	}
}
