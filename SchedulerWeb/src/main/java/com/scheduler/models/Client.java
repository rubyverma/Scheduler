package com.scheduler.models;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	private int clientId;
	private String clientName;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String memo;
	private String logo;
	private String phone1;
	private String phone2;
	private String phone3;
	private String contactPerson;
	private String website;
	private String token;
	private int emailVerified;
	private Date m_dateJoined;
}
