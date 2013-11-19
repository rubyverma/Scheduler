package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficialUser {
	
	private int officialId;
	private int departmentId;
	private int roleId;
	private String roleName;
	private String officialName;
	private String password;
	private String repassword;
	private String email;
	private String firstName;
	private String lastName;
	private Date dateJoined;
	private Date lastLogin;

}
