package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campus {
	
	private int m_campusId;
	private int m_clientId;
	private String m_campusName;
	private String m_campusAddress;
	private Date m_dateCreated;
	
	
}
