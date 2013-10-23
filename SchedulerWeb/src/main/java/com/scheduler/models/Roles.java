package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
	private int roleId;
	private int clientId;
	private String roleName;
	private String privilege;
	private String description;
}
