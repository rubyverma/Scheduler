package com.scheduler.models;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	private int departmentId;
	private int campusId;
	private String departmentName;
	private String departmentHod;
	private Long contactInfo;
	private String departmentDescription;
	private Date dateCreated;
	private List<OfficialUser> officialUsers = new ArrayList<OfficialUser>();

	private Map<String, String> slotsMap = new HashMap<String, String>();
	private List<Departmenttimeslot> slots;
}

