package com.scheduler.models;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campus {
	
	private int campusId;
	private int clientId;
	private String campusName;
	private String campusAddress;
	private Date dateCreated;
}
